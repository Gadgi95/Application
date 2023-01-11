package com.example.Application.repository.datajpa;

import com.example.Application.model.Administrator;
import com.example.Application.model.Users;
import com.example.Application.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.BiConsumer;

class DataJpaUsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    private BiConsumer<Users, Users> assertion;

    @Test
    public void save() {
        Users created = usersRepository.save(new Administrator(null,"Murat", "1111", "murat@gmail.com"));
        Integer newId = created.getId();
        Users newUsers = new Administrator(null,"Murat", "1111", "murat@gmail.com");
        assertion.accept(created, newUsers);
        newUsers.setId(newId);
    }
}