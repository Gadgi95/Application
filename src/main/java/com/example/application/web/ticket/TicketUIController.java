package com.example.application.web.ticket;

import com.example.application.model.Material;
import com.example.application.model.Role;
import com.example.application.model.Ticket;
import com.example.application.service.MaterialService;
import com.example.application.service.TicketService;
import com.example.application.service.UserService;
import com.example.application.util.exception.NotFoundException;
import com.example.application.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import static com.example.application.repository.datajpa.DataJpaTicketRepository.getTemp;
import static com.example.application.util.DateTimeUtil.parseLocalDate;
import static com.example.application.util.DateTimeUtil.parseLocalTime;
import static com.example.application.repository.datajpa.DataJpaTicketRepository.addTemp;
import static com.example.application.util.Util.cycleMaterials;

@Controller
@RequestMapping(value = "/tickets")
public class TicketUIController extends AbstractTicketController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MaterialService materialService;


    public static int ticketId;

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        ticketId = getId(request);
        List<Material> materials = super.get(ticketId).getMaterials();
        if (userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.ADMIN) |
                userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.SUPPLIER)) {

            model.addAttribute("ticket", super.get(ticketId));
            workWithTemp();
            for (int i = 1; i <= materials.size(); i++) {
                getTemp().add(materials.get(i - 1));
            }
            if (getTemp().size() == 1) {
                model.addAttribute("materials", cycleMaterials());
                return "ticketFormSupplier";
            }
            model.addAttribute("materials", cycleMaterials());
            return "ticketFormSupplier";
        } else {
            Ticket ticketForEdit = super.get(ticketId);
            ticketForEdit.setMaterials(null);
            model.addAttribute("ticket", ticketForEdit);
            getTemp().clear();
            getTemp().add(ticketForEdit);
            for (int i = 1; i <= materials.size(); i++) {
                getTemp().add(materials.get(i - 1));
            }
            model.addAttribute("materials", cycleMaterials());
            return "ticketFormForeman";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        workWithTemp();
        ((Ticket) getTemp().get(0)).setFlagToDelete(true);
        model.addAttribute("ticket", getTemp().get(0));
        Ticket ticketForId = ticketService.create((Ticket) getTemp().get(0), SecurityUtil.authUserId());
        ((Ticket) getTemp().get(0)).setId(ticketForId.getId());
        if (getTemp().size() == 1) {
            model.addAttribute("materials", cycleMaterials());
            return "ticketFormForeman";
        }
        model.addAttribute("materials", cycleMaterials());
        return "ticketFormForeman";
    }

    @PostMapping()
    public String updateOrCreate(HttpServletRequest request) {
        Ticket ticket = new Ticket(null, request.getParameter("name"), request.getParameter("status"), false,
                request.getParameter("objectName"), LocalDate.parse(request.getParameter("deliveryDate")));
        if (userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.ADMIN) |
                userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.SUPPLIER)) {
            super.updateForAdmin(ticket, getId(request));
        } else {
            if (request.getParameter("id").isEmpty()) {
                Ticket ticketTemp = (Ticket) getTemp().get(0);
                ticketTemp.setName(ticket.getName());
                ticketTemp.setObjectName(ticket.getObjectName());
                Ticket ticketForId = super.create(ticketTemp);
                for (int i = 1; i <= getTemp().size() - 1; i++) {
                    materialService.create((Material) getTemp().get(i), ticketForId.id());
                }
            } else {
                Ticket ticketTemp = (Ticket) getTemp().get(0);
                ticketTemp.setName(ticket.getName());
                ticketTemp.setObjectName(ticket.getObjectName());
                super.update(ticketTemp, getId(request));
                for (int i = 1; i <= getTemp().size() - 1; i++) {
                    materialService.create((Material) getTemp().get(i), getId(request));
                }
            }
            return "redirect:/tickets";
        }
        return "redirect:/tickets";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        try {
            super.delete(getId(request));
        } catch (NotFoundException e) {
            return "redirect:/tickets";
        }
        return "redirect:/tickets";
    }

    @GetMapping("/cancel")
    public String cancel() {
        try {
            if (((Ticket) getTemp().get(0)).isFlagToDelete()) {
                Integer id = ((Ticket) getTemp().get(0)).getId();
                ticketService.delete(id, SecurityUtil.authUserId());
                getTemp().clear();
                return "redirect:/tickets";
            }
        } catch (IndexOutOfBoundsException e) {
            return "redirect:/tickets";
        }
        return "redirect:/tickets";
    }

    @GetMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
        LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
        model.addAttribute("tickets", super.getBetween(startDate, startTime, endDate, endTime));
        return "tickets";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    private void workWithTemp() {
        getTemp().clear();
        addTemp(new Ticket(null, "new", "новая", false, "Рига", null));
    }
}