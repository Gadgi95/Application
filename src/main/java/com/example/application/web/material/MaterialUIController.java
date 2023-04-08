package com.example.application.web.material;

import com.example.application.model.Material;
import com.example.application.model.Ticket;
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

@Controller
@RequestMapping(value = "/tickets/materials")
public class MaterialUIController extends AbstractMaterialController {

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("material", super.get(getId(request)));
        return "materials";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("material", new Ticket(null, "new", "новая", false, "Рига"));
        return "materials";
    }

    @PostMapping()
    public String updateOrCreate(HttpServletRequest request) {
        Material material = new Material(request.getParameter("name"), Integer.parseInt(request.getParameter("quantity")),
                request.getParameter("characteristics"));

        if (request.getParameter("id").isEmpty()) {
            super.create(material, 1);
        } else {
            super.update(material, getId(request), 1);
        }
        return "redirect:/ticketFormForeman";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        try {
            super.delete(getId(request));
        } catch (NotFoundException e) {
            return "redirect:/ticketFormForeman";
        }
        return "redirect:/ticketFormForeman";
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
}
