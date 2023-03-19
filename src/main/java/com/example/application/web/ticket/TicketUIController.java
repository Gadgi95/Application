package com.example.application.web.ticket;

import com.example.application.model.Role;
import com.example.application.model.Ticket;
import com.example.application.service.UserService;
import com.example.application.util.TicketsUtil;
import com.example.application.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static com.example.application.util.DateTimeUtil.parseLocalDate;
import static com.example.application.util.DateTimeUtil.parseLocalTime;

@Controller
@RequestMapping(value = "/tickets")
public class TicketUIController extends AbstractTicketController {

    @Autowired
    private UserService userService;

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("ticket", super.get(getId(request)));
        return "ticketFormForeman";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ticket", new Ticket(null, "new", "новая", false, "Рига"));
        return "ticketFormForeman";
    }

    @PostMapping()
    public String updateOrCreate(HttpServletRequest request) {
        Ticket ticket = new Ticket(null, request.getParameter("name"), "новая", false,
                request.getParameter("objectName"));

        if (request.getParameter("id").isEmpty()) {
            super.create(ticket);
        } else {
            super.update(ticket, getId(request));
        }
        return "redirect:/tickets";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        if (userService.get(getId(request)).getRoles().contains(Role.ADMIN)) {
            super.delete(getId(request));
        } else
            super.delete(getId(request));
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
}