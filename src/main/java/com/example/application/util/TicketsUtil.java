package com.example.application.util;

import com.example.application.model.Ticket;
import com.example.application.to.TicketTo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TicketsUtil {
    public static List<TicketTo> getTos(Collection<Ticket> tickets) {
        List<TicketTo> ticketTos = new ArrayList<>();
        for (Ticket ticket: tickets) {
            if (ticket.getStatus().equals("новая")) {
                ticketTos.add(createTo(ticket, true));
            } else
                ticketTos.add(createTo(ticket, false));
        }
        return ticketTos;
    }

    private static TicketTo createTo(Ticket ticket, boolean excess) {
        return new TicketTo(ticket.getId(), ticket.getName(),
                ticket.getCreationDate(), ticket.getStatus(),
                ticket.getResponsibleSupplier(), ticket.getUser().getName(), ticket.getDeliveryDate(),
                ticket.getStatusChangeDate(), ticket.isClosed(),
                ticket.getClosingDate(), ticket.getClosedBy(),
                ticket.getObjectName(), excess);
    }

    public static List<TicketTo> getFilteredTos(Collection<Ticket> tickets, LocalTime startTime, LocalTime endTime) {
        return tickets.stream()
                .map(ticket -> createTo(ticket, ticket.getStatus().equals("новая")))
                .filter(ticketTo -> Util.isBetweenHalfOpen(ticketTo.getCreationDate().toLocalDate(), startTime, endTime)).toList();
    }

}
