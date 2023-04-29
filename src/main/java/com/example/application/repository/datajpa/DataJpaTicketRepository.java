package com.example.application.repository.datajpa;

import com.example.application.model.Material;
import com.example.application.model.Ticket;
import com.example.application.repository.TicketRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataJpaTicketRepository implements TicketRepository {

    private static final Sort SORT_CREATION_DATE = Sort.by(Sort.Direction.ASC, "creationDate");

    private final CrudTicketRepository crudTicketRepository;

    private final CrudUserRepository crudUserRepository;

    private static List<Object> temp = new ArrayList<>();

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
    public boolean deleteForAdmin(int id) {
        return crudTicketRepository.deleteForAdmin(id) != 0;
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
        return crudTicketRepository.getAll(userId);
    }

    @Override
    public List<Ticket> getAll() {
        return crudTicketRepository.findAll();
    }

    @Override
    public Ticket getWithMaterial(int id, int userId) {
        return crudTicketRepository.getWithMaterial(id, userId);
    }

    @Override
    public List<Ticket> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return crudTicketRepository.getBetweenHalfOpen(startDateTime, endDateTime, userId);
    }

    @Override
    public List<Ticket> getBetweenHalfOpenForAdmin(LocalDateTime atStartOfDayOrMin, LocalDateTime atStartOfNextDayOrMax) {
        return crudTicketRepository.getBetweenHalfOpenForAdmin(atStartOfDayOrMin, atStartOfNextDayOrMax);
    }

    public static List<Object> getTemp() {
        return temp;
    }

    public static <T> T addTemp(T object) {
        if (object instanceof Material) {
            ((Material) object).setId(getTemp().size());
            temp.add(object);
            return object;
        }
        temp.add(object);
        return object;
    }
}
