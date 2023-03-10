package com.example.Application;

import com.example.Application.model.User;
import com.example.Application.to.UserTo;
import com.example.Application.util.UserUtil;

import java.io.Serial;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User{
    @Serial
    private static final long serialVersionUID = 1L;

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
        setTo(UserUtil.asTo(user));
    }

    public int getId() {
        return userTo.id();
    }

    public void setTo(UserTo newTo) {
        newTo.setPassword(null);
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }
}
