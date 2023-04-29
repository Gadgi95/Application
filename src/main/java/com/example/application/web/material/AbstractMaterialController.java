package com.example.application.web.material;

import com.example.application.model.Material;
import com.example.application.model.Role;
import com.example.application.model.Ticket;
import com.example.application.service.MaterialService;
import com.example.application.service.TicketService;
import com.example.application.service.UserService;
import com.example.application.to.TicketTo;
import com.example.application.util.TicketsUtil;
import com.example.application.web.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.example.application.repository.datajpa.DataJpaTicketRepository.addTemp;
import static com.example.application.util.validation.ValidationUtil.*;

public class AbstractMaterialController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MaterialService materialService;

    public Material get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get ticket {} for user {}", id, userId);
        return materialService.get(id);
    }

    public Material getNew(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get ticket {} for user {}", id, userId);
        return materialService.getNew(id);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete ticket {} for user {}", id, userId);
        materialService.delete(id, userId);
    }

    public void deleteNew(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete ticket {} for user {}", id, userId);
        materialService.deleteNew(id);
    }

    public List<Material> getAllForTicket(int ticketId) {
        int userId = SecurityUtil.authUserId();
        log.info("getAll for user {}", userId);
        return materialService.getAllForTicket(ticketId);
    }

    public Material create(Material material, int ticketId) {
        int userId = SecurityUtil.authUserId();
        log.info("create {} for user {}", material, userId);
        checkNew(material);
        return materialService.create(material, ticketId, userId);
    }

    public void createNew(Material material) {
        int userId = SecurityUtil.authUserId();
        log.info("create {} for user {}", material, userId);
        checkNew(material);
        addTemp(material);
    }

    public void update(Material material, int id, int ticketId) {
        int userId = SecurityUtil.authUserId();
        log.info("update {} for user {}", material, userId);
        assureIdConsistent(material, id);
        materialService.update(material, ticketId, userId);
    }

    public void updateNew(Material material, int id) {
        int userId = SecurityUtil.authUserId();
        log.info("update {} for user {}", material, userId);
        assureIdConsistent(material, id);
        materialService.updateNew(material);
    }

    /**
     * <ol>Filter separately
     * <li>by date</li>
     * <li>by time for every date</li>
     * </ol>
     */
    public List<TicketTo> getBetween(@Nullable LocalDate startDate, @Nullable LocalTime startTime,
                                     @Nullable LocalDate endDate, @Nullable LocalTime endTime) {
        int userId = SecurityUtil.authUserId();
        log.info("getBetween dates({} - {}) time({} - {}) for user {}", startDate, endDate, startTime, endTime, userId);
        if (userService.get(userId).getRoles().contains(Role.ADMIN)) {
            List<Ticket> mealsDateFiltered = ticketService.deleteForAdmin(startDate, endDate);
            return TicketsUtil.getFilteredTos(mealsDateFiltered, startTime, endTime);
        } else {
            List<Ticket> mealsDateFiltered = ticketService.getBetweenInclusive(startDate, endDate, userId);
            return TicketsUtil.getFilteredTos(mealsDateFiltered, startTime, endTime);
        }
    }
}
