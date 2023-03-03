package com.example.application.web.user;

import com.example.application.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class AdminUIController extends AbstractUserController {
    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }
}
