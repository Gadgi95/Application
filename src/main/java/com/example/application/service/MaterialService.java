package com.example.application.service;

import com.example.application.model.Material;
import com.example.application.model.Ticket;
import com.example.application.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.application.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class MaterialService {

    private final TicketService ticketService;
    private final MaterialRepository materialRepository;

    public MaterialService(TicketService ticketService, MaterialRepository materialRepository) {
        this.ticketService = ticketService;
        this.materialRepository = materialRepository;
    }

    public Material get(int id) {
        return checkNotFoundWithId(materialRepository.get(id), id);
    }

    public void delete(int id, int userId) {
        Ticket ticket = checkNotFoundWithId(ticketService.get(id, userId), userId);
        checkNotFoundWithId(materialRepository.delete(id, ticket.id()), id);
    }

    public List<Material> getAllForTicket(int ticketId) {
        return materialRepository.getAllForTicket(ticketId);
    }

    public void update(Material material, int ticketId, int userId) {
        Assert.notNull(material, "meal must not be null");
        Ticket ticket = checkNotFoundWithId(ticketService.get(ticketId, userId), userId);
        checkNotFoundWithId(materialRepository.save(material), material.id());
    }

    public Material create(Material material, int ticketId, int userId) {
        Assert.notNull(material, "meal must not be null");
        material.setTicket(ticketService.get(ticketId, userId));
        return materialRepository.save(material);
    }
}
