package com.example.application.web.user;

import com.example.application.model.Role;
import com.example.application.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Objects;


@Controller
@RequestMapping(value = "/users")
public class AdminUIController extends AbstractUserController {

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getId(request)));
        return "userForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User(null, "new", "12345@gfdg.com", "3123534", Collections.singleton(Role.FOREMAN)));
        return "userForm";
    }

    @PostMapping("/create")
    public String updateOrCreate(HttpServletRequest request) {
        User user = new User(null, request.getParameter("name"), request.getParameter("email"),
                request.getParameter("password"), Collections.singleton(Role.FOREMAN));

        if (request.getParameter("id").isEmpty()) {
            super.create(user);
        } else {
            super.update(user, getId(request));
        }
        return "redirect:/users";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
//    @Override
//    public List<User> getAll() {
//        return super.getAll();
//    }
//
//    @Override
//    public User get(int id) {
//        return super.get(id);
//    }
}
