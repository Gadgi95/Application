package com.example.application.repository.datajpa;

import com.example.application.model.Ticket;
import com.example.application.repository.AbstractServiceTest;
import com.example.application.service.TicketService;
import org.junit.jupiter.api.Test;

class DataJpaTicketRepositoryTest extends AbstractServiceTest {

    TicketService ticketService;

    @Test
    void getWithMaterial() {
        Ticket ticket = ticketService.get(1);
        System.out.println(ticket.toString());
    }
}