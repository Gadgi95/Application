package com.example.application;

import com.example.application.model.User;

import java.io.Serial;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User{
    @Serial
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
        setTo(user);
    }

    public int getId() {
        return user.id();
    }

    public void setTo(User newTo) {
        newTo.setPassword(null);
        user = newTo;
    }

    public User getUserTo() {
        return user;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}
