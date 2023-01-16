package com.example.Application.repository.datajpa;

import com.example.Application.to.UserTo;
import com.example.Application.repository.UsersRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaUsersRepository implements UsersRepository {

    private final CrudUsersRepository crudRepository;
    public DataJpaUsersRepository(CrudUsersRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public UserTo save(UserTo user) {
        return crudRepository.save(user);
    }
}
