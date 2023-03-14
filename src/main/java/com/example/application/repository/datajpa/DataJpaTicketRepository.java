package com.example.application.repository.datajpa;

import com.example.application.model.Material;
import com.example.application.model.Ticket;
import com.example.application.repository.TicketRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaTicketRepository implements TicketRepository {

    private static final Sort SORT_CREATION_DATE = Sort.by(Sort.Direction.ASC, "creationDate");

    private final CrudTicketRepository crudTicketRepository;

    private final CrudUserRepository crudUserRepository;

    public DataJpaTicketRepository(CrudTicketRepository crudTicketRepository, CrudUserRepository crudUserRepository) {
        this.crudTicketRepository = crudTicketRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public Ticket save(Ticket ticket, int userId) {
        if (!ticket.isNew()) {
            return null;
        }
        ticket.setUser(crudUserRepository.getOne(userId));
        return crudTicketRepository.save(ticket);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudTicketRepository.delete(id, userId) != 0;
    }

    @Override
    public Ticket get(int id, int userId) {
        if (crudTicketRepository.findById(id) == null) {
            return null;
        }
        return crudTicketRepository.findById(id);
    }

    @Override
    public List<Ticket> getAll(int userId) {
        return crudTicketRepository.findAll(SORT_CREATION_DATE);
    }

    @Override
    public Ticket getWithMaterial(int id, int userId, List<Material> materialList) {
        return null;
//        return crudTicketRepository.getWithMaterial(id, userId, materialList);
    }

    @Override
    public List<Ticket> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return crudTicketRepository.getBetweenHalfOpen(startDateTime, endDateTime, userId);
    }
}
