//package com.example.Application.repository.datajpa;
//
//import com.example.Application.model.Administrator;
//import com.example.Application.model.Role;
//import com.example.Application.to.UserTo;
//import com.example.Application.repository.AbstractServiceTest;
//import com.example.Application.repository.UsersRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.function.BiConsumer;
//
//class DataJpaUsersRepositoryTest extends AbstractServiceTest {
//
//    @Autowired
//    protected UsersRepository usersRepository;
//
//    private BiConsumer<UserTo, UserTo> assertion;
//
//    @Test
//    public void save() {
//        UserTo created = usersRepository.save(new Administrator((int)(Math.random() * 2), "Murat", " ", "murat@murat.ru", Role.ADMINISTRATOR));
//        Integer newId = created.getId();
//        UserTo newUsers = new Administrator((int)(Math.random() * 2), "Murat", " ", "murat@murat.ru", Role.ADMINISTRATOR));
//        assertion.accept(created, newUsers);
//        newUsers.setId(newId);
//    }
//}