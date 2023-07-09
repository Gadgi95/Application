package com.example.application.to;

import com.example.application.model.ApplicationStatus;
import com.example.application.model.Material;
import com.example.application.model.ObjectName;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TicketTo {

    private final Integer id;

    private final String name;

    private final LocalDateTime creationDate;

    private final String status;

    private final String responsibleSupplier;
    private final String responsibleForeman;

    private final LocalDate deliveryDate;

    private final String statusChangeDate;

    private final boolean isClosed;

    private final String closingDate;

    private final String closedBy;

    private final String objectName;

    private final boolean excess;

    @ConstructorProperties({"id", "name", "creationDate", "status", "responsibleSupplier", "responsibleForeman", "deliveryDate", "statusChangeDate",
            "closingDate", "closedBy", "objectName", "isClosed", "excess"})
    public TicketTo(Integer id, String name, LocalDateTime creationDate, String status, String responsibleSupplier, String responsibleForeman, LocalDate deliveryDate,
                    String statusChangeDate, boolean isClosed, String closingDate, String closedBy,
                    String objectName, boolean excess) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
        this.responsibleSupplier = responsibleSupplier;
        this.responsibleForeman = responsibleForeman;
        this.deliveryDate = deliveryDate;
        this.statusChangeDate = statusChangeDate;
        this.isClosed = isClosed;
        this.closingDate = closingDate;
        this.closedBy = closedBy;
        this.objectName = objectName;
        this.excess = excess;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getResponsibleSupplier() {
        return responsibleSupplier;
    }
    public String getResponsibleForeman() {
        return responsibleForeman;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatusChangeDate() {
        return statusChangeDate;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public String getObjectName() {
        return objectName;
    }

    public boolean isExcess() {
        return excess;
    }

    @Override
    public String toString() {
        return "TicketTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", responsibleSupplier='" + responsibleSupplier + '\'' +
                ", responsibleForeman='" + responsibleForeman + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", statusChangeDate='" + statusChangeDate + '\'' +
                ", isClosed=" + isClosed +
                ", closingDate='" + closingDate + '\'' +
                ", closedBy='" + closedBy + '\'' +
                ", objectName='" + objectName + '\'' +
                ", excess=" + excess +
                '}';
    }
}
