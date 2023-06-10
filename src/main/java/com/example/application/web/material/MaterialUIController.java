package com.example.application.web.material;

import com.example.application.model.Material;
import com.example.application.model.Role;
import com.example.application.model.Ticket;
import com.example.application.service.TicketService;
import com.example.application.service.UserService;
import com.example.application.util.exception.NotFoundException;
import com.example.application.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.application.util.DateTimeUtil.parseLocalDate;
import static com.example.application.util.DateTimeUtil.parseLocalTime;
import static com.example.application.repository.datajpa.DataJpaTicketRepository.getTemp;
import static com.example.application.util.Util.cycleMaterials;

@Controller
@RequestMapping(value = "/tickets/materials")
public class MaterialUIController extends AbstractMaterialController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String getTicketWithMaterials(Model model) {
        modelTicketWithMaterials(model);
        return "ticketFormForeman";
    }

    //Отредактировать материал при редактировании заявки
    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        editMaterial(request, model);
        return "materials";
    }

    //Отредактировать материал при создании заявки
    @GetMapping("/update/new")
    public String updateNew(HttpServletRequest request, Model model) {
        editMaterial(request, model);
//        model.addAttribute("material", super.getNew(getId(request)));
        return "materialsNew";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("material", new Material(null, "Кирпич", 1, "3Х5", false, ""));
        return "materials";
    }

    @GetMapping("/create/new")
    public String createNew(Model model) {
        model.addAttribute("material", new Material(null, "Кирпич", 1, "3Х5", false, ""));
        return "materialsNew";
    }

    //Создание и редактирование материала при редактировании заявки
    @PostMapping("/create")
    public String updateOrCreate(HttpServletRequest request, Model model) {
        Material material;
        if (request.getParameter("id").isEmpty()) {
            material = getMaterial(request);
            setDateFactoryMarriage(material);
            material.setTicket((Ticket) getTemp().get(0));
            getTemp().add(material);
//            super.create(material, TicketUIController.ticketId);
        } else {
            Ticket ticketForMaterial = (Ticket) getTemp().get(0);
            material = getMaterial(request);
            List<Material> materials = new ArrayList<>();
            int materialId = getId(request);
            material.setTicket(ticketForMaterial);
            material.setId(materialId);
            for (int i = 1; i <= getTemp().size() - 1; i++) {
                Material materialFromTemp = (Material) getTemp().get(i);
                materials.add(materialFromTemp);
                if (materialFromTemp.getId() == materialId) {
                    setDateFactoryMarriage(material);
                    if (materialFromTemp.getMarriageDetectionDate() == null) {
                        getTemp().set(i, material);
                        materials.set(i - 1, material);
                    } else if (material.getMarriageDetectionDate() == null) {
                        if (materialFromTemp.getMarriageDetectionDate() != null) {
                            getTemp().set(i, material);
                            materials.set(i - 1, material);
                        }
                    } else if (material.getMarriageDetectionDate().isEqual(materialFromTemp.getMarriageDetectionDate())
                            || material.getMarriageDetectionDate().isAfter(materialFromTemp.getMarriageDetectionDate())) {
                        material.setMarriageDetectionDate(materialFromTemp.getMarriageDetectionDate());
                        getTemp().set(i, material);
                        materials.set(i - 1, material);
                    }
                }
            }
//            super.update(material, getId(request));
            model.addAttribute("ticket", ticketForMaterial);
            model.addAttribute("materials", materials);
            return "ticketFormForeman";
        }
        modelTicketWithMaterials(model);
        return "ticketFormForeman";
    }

    //Создание и редактирование материала при создании заявки
    @PostMapping("/create/new")
    public String updateOrCreateNew(HttpServletRequest request, Model model) {
        Material material;
        if (request.getParameter("id").isEmpty()) {
            material = getMaterial(request);
            setDateFactoryMarriage(material);
            super.createNew(getMaterial(request));
        } else {
            int materialId = getId(request);
            material = getMaterial(request);
            material.setId(materialId);
            for (int i = 1; i <= getTemp().size() - 1; i++) {
                Material materialFromTemp = (Material) getTemp().get(i);
                if (materialFromTemp.getId() == materialId) {
                    setDateFactoryMarriage(material);
                    if (materialFromTemp.getMarriageDetectionDate() == null) {
                        getTemp().set(i, material);
                    } else if (material.getMarriageDetectionDate() == null) {
                        if (materialFromTemp.getMarriageDetectionDate() != null) {
                            getTemp().set(i, material);
                        }
                    } else if (material.getMarriageDetectionDate().isEqual(materialFromTemp.getMarriageDetectionDate())
                            || material.getMarriageDetectionDate().isAfter(materialFromTemp.getMarriageDetectionDate())) {
                        material.setMarriageDetectionDate(materialFromTemp.getMarriageDetectionDate());
                        getTemp().set(i, material);
                    }
                }
            }
            super.updateNew(material);
        }
        modelTicketWithMaterials(model);
        return "ticketFormForeman";
    }

    //Удалить материал при редактировании
    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        if (userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.ADMIN) |
                userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.SUPPLIER)) {
            try {
                super.delete(getId(request));
            } catch (NotFoundException e) {
                return "redirect:/tickets/materials";
            }
            return "redirect:/tickets/materials";
        } else {
            try {
                super.delete(getId(request));
            } catch (NotFoundException e) {
                return "redirect:/tickets/materials";
            }
            return "redirect:/tickets/materials";
        }

    }

    //Удалить материал при создании заявки
    @GetMapping("/delete/new")
    public String deleteNew(HttpServletRequest request, Model model) {
        try {
            super.deleteNew(getId(request));
        } catch (NotFoundException e) {
            modelTicketWithMaterials(model);
            return "ticketFormForeman";
        }
        modelTicketWithMaterials(model);
        return "ticketFormForeman";
    }

    @GetMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
        LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
        model.addAttribute("tickets", super.getBetween(startDate, startTime, endDate, endTime));
        return "materials";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    private Material getMaterial(HttpServletRequest request) {
        return new Material(null, request.getParameter("name"), Integer.parseInt(request.getParameter("quantity")),
                request.getParameter("characteristics"), Boolean.parseBoolean(request.getParameter("hasFactoryMarriage")), request.getParameter("marriageDescription"));
    }

    private void modelTicketWithMaterials(Model model) {
        model.addAttribute("ticket", getTemp().get(0));
        model.addAttribute("materials", cycleMaterials());
    }

    private void setDateFactoryMarriage(Material material) {
        if (material.isHasFactoryMarriage()) {
            if (material.getMarriageDetectionDate() == null) {
                material.setMarriageDetectionDate(LocalDate.now());
            }
        } else if (material.getMarriageDetectionDate() != null) {
            material.setMarriageDetectionDate(null);
        }
    }

    private void editMaterial(HttpServletRequest request, Model model) {
        Material material;
        int requestId = getId(request);
        for (int i = 1; i <= getTemp().size() - 1; i++) {
            material = (Material) getTemp().get(i);
            if (material.getId() == requestId) {
                model.addAttribute("material", material);
            }
        }
    }
}
