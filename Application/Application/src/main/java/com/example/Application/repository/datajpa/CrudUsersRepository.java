package com.example.Application.repository.datajpa;

import com.example.Application.to.UserTo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudUsersRepository extends JpaRepository<UserTo, Integer> {

}
