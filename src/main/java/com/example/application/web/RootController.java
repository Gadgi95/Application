package com.example.application.web;

import com.example.application.model.Role;
import com.example.application.model.Ticket;
import com.example.application.service.TicketService;
import com.example.application.service.UserService;
import com.example.application.util.TicketsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RootController {
    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String root() {
        log.info("root");
        return "redirect:tickets";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        log.info("users");
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/login")
    public String login() {
        log.info("login");
        return "login";
    }

    @GetMapping("/tickets")
    public String getTickets(Model model) {
        log.info("tickets");
        if (userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.ADMIN) |
                userService.get(SecurityUtil.authUserId()).getRoles().contains(Role.SUPPLIER)) {
            model.addAttribute("tickets",
                    TicketsUtil.getTos(ticketService.getAll()));
        } else
            model.addAttribute("tickets",
                    TicketsUtil.getTos(ticketService.getAll(SecurityUtil.authUserId())));
        return "tickets";
    }
}
