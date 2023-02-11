package com.example.Application.to;

import com.example.Application.model.ApplicationStatus;
import com.example.Application.model.Material;
import com.example.Application.model.ObjectName;

import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TicketTo {

    private final Integer id;

    private final String name;

    private final String creationDate;

    private final ApplicationStatus status;

    private final String responsibleSupplier;

    private final String deliveryDate;

    private final String statusChangeDate;

    private final boolean isClosed;

    private final String closingDate;

    private final String closedBy;

    private final boolean hasFactoryMarriage;

    private final Date marriageDetectionDate;

    private final String marriageDetectedBy;

    private final String marriageDescription;

    private final String marriagePhotoUrl;

    private final ObjectName objectName;

    private final List<Material> materials;

    private final boolean excess;

    @ConstructorProperties({"id", "name", "creationDate", "status", "responsibleSupplier", "deliveryDate", "statusChangeDate",
            "closingDate", "closedBy", "hasFactoryMarriage", "marriageDetectionDate", "marriageDetectedBy", "marriageDescription",
            "marriagePhotoUrl", "objectName", "materials", "isClosed", "excess"})
    public TicketTo(Integer id, String name, String creationDate, ApplicationStatus status, String responsibleSupplier, String deliveryDate,
                    String statusChangeDate, boolean isClosed, String closingDate, String closedBy, boolean hasFactoryMarriage, Date marriageDetectionDate,
                    String marriageDetectedBy, String marriageDescription, String marriagePhotoUrl,
                    ObjectName objectName, List<Material> materials, boolean excess) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
        this.responsibleSupplier = responsibleSupplier;
        this.deliveryDate = deliveryDate;
        this.statusChangeDate = statusChangeDate;
        this.isClosed = isClosed;
        this.closingDate = closingDate;
        this.closedBy = closedBy;
        this.hasFactoryMarriage = hasFactoryMarriage;
        this.marriageDetectionDate = marriageDetectionDate;
        this.marriageDetectedBy = marriageDetectedBy;
        this.marriageDescription = marriageDescription;
        this.marriagePhotoUrl = marriagePhotoUrl;
        this.objectName = objectName;
        this.materials = materials;
        this.excess = excess;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public String getResponsibleSupplier() {
        return responsibleSupplier;
    }

    public String getDeliveryDate() {
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

    public boolean isHasFactoryMarriage() {
        return hasFactoryMarriage;
    }

    public Date getMarriageDetectionDate() {
        return marriageDetectionDate;
    }

    public String getMarriageDetectedBy() {
        return marriageDetectedBy;
    }

    public String getMarriageDescription() {
        return marriageDescription;
    }

    public String getMarriagePhotoUrl() {
        return marriagePhotoUrl;
    }

    public ObjectName getObjectName() {
        return objectName;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public boolean isExcess() {
        return excess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketTo ticketTo = (TicketTo) o;
        return isClosed == ticketTo.isClosed && hasFactoryMarriage == ticketTo.hasFactoryMarriage && excess == ticketTo.excess
                && id.equals(ticketTo.id) && name.equals(ticketTo.name) && creationDate.equals(ticketTo.creationDate)
                && status == ticketTo.status && responsibleSupplier.equals(ticketTo.responsibleSupplier) && deliveryDate.equals(ticketTo.deliveryDate)
                && statusChangeDate.equals(ticketTo.statusChangeDate) && closingDate.equals(ticketTo.closingDate) && closedBy.equals(ticketTo.closedBy)
                && marriageDetectionDate.equals(ticketTo.marriageDetectionDate) && marriageDetectedBy.equals(ticketTo.marriageDetectedBy)
                && marriageDescription.equals(ticketTo.marriageDescription) && marriagePhotoUrl.equals(ticketTo.marriagePhotoUrl)
                && objectName == ticketTo.objectName && materials.equals(ticketTo.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, status, responsibleSupplier, deliveryDate, statusChangeDate,
                isClosed, closingDate, closedBy, hasFactoryMarriage, marriageDetectionDate, marriageDetectedBy,
                marriageDescription, marriagePhotoUrl, objectName, materials, excess);
    }

    @Override
    public String toString() {
        return "TicketTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", status=" + status +
                ", responsibleSupplier='" + responsibleSupplier + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", statusChangeDate='" + statusChangeDate + '\'' +
                ", isClosed=" + isClosed +
                ", closingDate='" + closingDate + '\'' +
                ", closedBy='" + closedBy + '\'' +
                ", hasFactoryMarriage=" + hasFactoryMarriage +
                ", marriageDetectionDate=" + marriageDetectionDate +
                ", marriageDetectedBy='" + marriageDetectedBy + '\'' +
                ", marriageDescription='" + marriageDescription + '\'' +
                ", marriagePhotoUrl='" + marriagePhotoUrl + '\'' +
                ", objectName=" + objectName +
                ", materials=" + materials +
                ", excess=" + excess +
                '}';
    }
}
