package com.example.application.web.ticket;

import com.example.application.model.Ticket;
import com.example.application.util.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static com.example.application.repository.datajpa.DataJpaTicketRepository.getTemp;
import static com.example.application.util.DateTimeUtil.parseLocalDate;
import static com.example.application.util.DateTimeUtil.parseLocalTime;
import static com.example.application.repository.datajpa.DataJpaTicketRepository.addTemp;
import static com.example.application.util.Util.cycleMaterials;

@Controller
@RequestMapping(value = "/tickets")
public class TicketUIController extends AbstractTicketController {

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("ticket", super.get(getId(request)));
        return "ticketAddFormForeman";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ticket", new Ticket(null, "new", "новая", false, "Рига"));
        getTemp().clear();
        addTemp(new Ticket(null, "new", "новая", false, "Рига"));
        if (getTemp().size() == 1) {
            return "ticketAddFormForeman";
        }
        model.addAttribute("material", cycleMaterials());
        return "ticketAddFormForeman";
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
        try {
            super.delete(getId(request));
        } catch (NotFoundException e) {
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
}