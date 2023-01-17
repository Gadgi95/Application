package com.example.Application.repository.datajpa;

import com.example.Application.core.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudTicketRepository extends JpaRepository<Ticket, Integer> {

}
