package com.example.Application.repository.datajpa;

import com.example.Application.model.User;
import org.springframework.data.jpa.repository.*;

public interface CrudUserRepository extends JpaRepository<User, Integer> {

}
