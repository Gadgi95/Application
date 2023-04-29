package com.example.application.web.material;

import com.example.application.model.Material;
import com.example.application.util.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static com.example.application.util.DateTimeUtil.parseLocalDate;
import static com.example.application.util.DateTimeUtil.parseLocalTime;
import static com.example.application.repository.datajpa.DataJpaTicketRepository.getTemp;
import static com.example.application.util.Util.cycleMaterials;

@Controller
@RequestMapping(value = "/tickets/materials")
public class MaterialUIController extends AbstractMaterialController {

    @GetMapping
    public String getTicketWithMaterials(Model model) {
        modelTicketWithMaterials(model);
        return "ticketAddFormForeman";
    }

    //Отредактировать материал при редактировании заявки
    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("material", super.get(getId(request)));
        return "materials";
    }

    //Отредактировать материал при создании заявки
    @GetMapping("/updateNew")
    public String updateNew(HttpServletRequest request, Model model) {
        model.addAttribute("material", super.getNew(getId(request)));
        return "materialsNew";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("material", new Material(null, "Кирпич", 1, "3Х5", false, ""));
        return "materialsNew";
    }

    //Создание материала при редактировании заявки
    @PostMapping("/create")
    public String updateOrCreate(HttpServletRequest request, Model model) {
        if (request.getParameter("id").isEmpty()) {
            super.create(getMaterial(request), 0);
        } else {
            super.update(getMaterial(request), getId(request), 1);
        }
        modelTicketWithMaterials(model);
        return "ticketAddFormForeman";
    }

    //Создание материала при создании заявки
    @PostMapping("/createNew")
    public String updateOrCreateNew(HttpServletRequest request, Model model) {
        if (request.getParameter("id").isEmpty()) {
            super.createNew(getMaterial(request));
        } else {
            super.updateNew(getMaterial(request), getId(request));
        }
        modelTicketWithMaterials(model);
        return "ticketAddFormForeman";
    }
    //Удалить материал при редактировании
    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        try {
            super.delete(getId(request));
        } catch (NotFoundException e) {
            return "redirect:/ticketFormForeman";
        }
        return "redirect:/ticketFormForeman";
    }

    //Удалить материал при создании заявки
    @GetMapping("/deleteNew")
    public String deleteNew(HttpServletRequest request, Model model) {
        try {
            super.deleteNew(getId(request));
        } catch (NotFoundException e) {
            modelTicketWithMaterials(model);
            return "ticketAddFormForeman";
        }
        modelTicketWithMaterials(model);
        return "ticketAddFormForeman";
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
}
