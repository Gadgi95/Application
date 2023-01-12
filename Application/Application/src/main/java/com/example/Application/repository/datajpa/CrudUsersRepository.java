package com.example.Application.repository.datajpa;

import com.example.Application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudUsersRepository extends JpaRepository<Users, Integer> {

}
