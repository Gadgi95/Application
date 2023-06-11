package com.example.application.repository.datajpa;

import com.example.application.AuthorizedUser;
import com.example.application.model.Material;
import com.example.application.model.Ticket;
import com.example.application.repository.TicketRepository;
import com.example.application.web.SecurityUtil;
import org.hibernate.Hibernate;
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

    private final CrudMaterialRepository crudMaterialRepository;

    private static List<Object> temp = new ArrayList<>();

    public DataJpaTicketRepository(CrudTicketRepository crudTicketRepository, CrudUserRepository crudUserRepository, CrudMaterialRepository crudMaterialRepository) {
        this.crudTicketRepository = crudTicketRepository;
        this.crudUserRepository = crudUserRepository;
        this.crudMaterialRepository = crudMaterialRepository;
    }

    @Override
    @Transactional
    public Ticket save(Ticket ticket, int userId) {
        Integer ticketId = ticket.getId();
        if (ticketId == null) {
            ticket.setUser(crudUserRepository.getById(userId));
            return crudTicketRepository.save(ticket);
        }
        if (!ticket.isNew() && get(ticket.getId()) == null) {
            return null;
        }
        Ticket ticketFromBase = crudTicketRepository.getById(ticketId);
        ticket.setUser(crudUserRepository.getById(userId));
        ticket.setStatus(ticketFromBase.getStatus());
        ticket.setResponsibleSupplier(ticketFromBase.getResponsibleSupplier());
        ticket.setDeliveryDate(ticketFromBase.getDeliveryDate());
        ticket.setFlagToDelete(ticketFromBase.isFlagToDelete());
        ticket.setClosed(ticketFromBase.isClosed());
        ticket.setClosingDate(ticketFromBase.getClosingDate());
        ticket.setClosedBy(ticketFromBase.getClosedBy());
        return crudTicketRepository.save(ticket);
    }

    @Override
    @Transactional
    public Ticket saveForAdmin(Ticket ticket) {
        int userId = SecurityUtil.authUserId();
        if (!ticket.isNew() && get(ticket.getId()) == null) {
            return null;
        }
        Ticket ticketFromBase = crudTicketRepository.getById(ticket.getId());
        ticket.setCreationDate(ticketFromBase.getCreationDate());
        ticket.setUser(crudUserRepository.getById(ticketFromBase.getUser().getId()));
        ticket.setResponsibleSupplier(crudUserRepository.getById(userId).getName());
        ticket.setFlagToDelete(ticketFromBase.isFlagToDelete());
        ticket.setName(ticketFromBase.getName());
        ticket.setObjectName(ticketFromBase.getObjectName());
        ticket.setStatusChangeDate(ticketFromBase.getStatusChangeDate());
//        ticket.setStatusChangeDate();
        if (ticketFromBase.getDeliveryDate() == null || ticket.getDeliveryDate().isAfter(ticketFromBase.getDeliveryDate())) {
            ticket.setDeliveryDate(ticket.getDeliveryDate());
            return crudTicketRepository.save(ticket);
        }
        if (ticket.getDeliveryDate() == null || ticket.getDeliveryDate().isEqual(ticketFromBase.getDeliveryDate())) {
            ticket.setDeliveryDate(ticketFromBase.getDeliveryDate());
            return crudTicketRepository.save(ticket);
        }
        if (ticket.getDeliveryDate().isBefore(ticketFromBase.getDeliveryDate())) {
            ticket.setDeliveryDate(ticketFromBase.getDeliveryDate());
            return crudTicketRepository.save(ticket);
        }
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
    public Ticket get(int id) {
        if (crudTicketRepository.findById(id) == null) {
            return null;
        }
        return crudTicketRepository.findById(id);
    }

    @Transactional
    public Ticket getTicketForMaterial(int materialId) {
        if (DataJpaMaterialRepository.temp == null) {
            Ticket ticket = crudTicketRepository.getById(crudMaterialRepository.getById(materialId).getTicket().getId());
            Hibernate.initialize(ticket.getMaterials());
            return ticket;
        }
        Ticket ticket = DataJpaMaterialRepository.temp;
        Hibernate.initialize(ticket.getMaterials());
        return ticket;
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
    public Ticket getWithMaterial(int id) {
        return crudTicketRepository.getWithMaterial(id);
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
            ((Material) object).setFlagToDelete(true);
            temp.add(object);
            return object;
        }
        temp.add(object);
        return object;
    }
}
