package com.example.application.service;

import com.example.application.model.Material;
import com.example.application.model.Ticket;
import com.example.application.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.example.application.util.validation.ValidationUtil.checkNotFoundWithId;
import static com.example.application.repository.datajpa.DataJpaTicketRepository.getTemp;

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

    //Получить и проверить материал при создании заявки
    public Material getNew(int id) {
        return (Material) checkNotFoundWithId(getTemp().get(id), id);
    }

    //Удалить материал при редактировании заявки
    public void delete(int id) {
        if (id <= 500_000) {
            Ticket ticket = (Ticket) getTemp().get(0);
            checkNotFoundWithId(materialRepository.delete(id, ticket.id()), id);
            deleteNew(id);
        } else {
            deleteNew(id);
        }
    }

    //Удалить материал при создании заявки
    public void deleteNew(int id) {
        for (int i = 1; i <= getTemp().size() - 1; i++) {
            if (id == ((Material) getTemp().get(i)).getId()) {
                getTemp().remove(i);
            }
        }
    }

    public List<Material> getAllForTicket(int ticketId) {
        return materialRepository.getAllForTicket(ticketId);
    }

    public void update(Material material) {
        Assert.notNull(material, "meal must not be null");
        checkNotFoundWithId(materialRepository.save(material), material.id());
    }

    //Редактировать материал при создании заявки
    public void updateNew(Material material) {
        Assert.notNull(material, "meal must not be null");
        int materialId = material.getId();
        for (int i = 1; i <= getTemp().size() - 1; i++) {
            if (material.getId() == materialId) {
                Material materialNew = (Material) getTemp().get(i);
                materialNew.setName(material.getName());
                materialNew.setQuantity(material.getQuantity());
                materialNew.setCharacteristics(material.getCharacteristics());
                materialNew.setHasFactoryMarriage(material.isHasFactoryMarriage());
                materialNew.setMarriageDescription(material.getMarriageDescription());
            }
        }
    }

    public Material create(Material material, int ticketId) {
        Assert.notNull(material, "meal must not be null");
        material.setTicket(ticketService.get(ticketId));
        if (material.getId() >= 500_000) {
            material.setId(null);
        }
        return materialRepository.save(material);
    }

    private void setDateFactoryMarriage(Material material) {
        if (material.isHasFactoryMarriage()) {
            if (material.getMarriageDetectionDate() == null) {
                material.setMarriageDetectionDate(LocalDate.now());
            }
        } else if (material.getMarriageDetectionDate() != null) {
            material.setMarriageDetectionDate(null);
        }
    }
}
