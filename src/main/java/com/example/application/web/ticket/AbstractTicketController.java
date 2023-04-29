package com.example.application.web.ticket;

import com.example.application.model.Role;
import com.example.application.model.Ticket;
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

import static com.example.application.util.validation.ValidationUtil.assureIdConsistent;
import static com.example.application.util.validation.ValidationUtil.checkNew;


public abstract class AbstractTicketController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService service;

    public Ticket get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get ticket {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete ticket {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<TicketTo> getAll() {
        int userId = SecurityUtil.authUserId();
        log.info("getAll for user {}", userId);
        return TicketsUtil.getTos(service.getAll(userId));
    }

    public Ticket create(Ticket ticket) {
        int userId = SecurityUtil.authUserId();
        log.info("create {} for user {}", ticket, userId);
        checkNew(ticket);
        return service.create(ticket, userId);
    }

    public void update(Ticket ticket, int id) {
        int userId = SecurityUtil.authUserId();
        log.info("update {} for user {}", ticket, userId);
        assureIdConsistent(ticket, id);
        service.update(ticket, userId);
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
            List<Ticket> mealsDateFiltered = service.deleteForAdmin(startDate, endDate);
            return TicketsUtil.getFilteredTos(mealsDateFiltered, startTime, endTime);
        } else {
            List<Ticket> mealsDateFiltered = service.getBetweenInclusive(startDate, endDate, userId);
            return TicketsUtil.getFilteredTos(mealsDateFiltered, startTime, endTime);
        }
    }
}