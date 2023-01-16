package com.example.Application.repository;

import com.example.Application.to.UserTo;

public interface UsersRepository {
    UserTo save(UserTo user);
}
