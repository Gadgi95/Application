package com.example.application.model;

import com.example.application.HasId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "materials")
//@NamedEntityGraph(name = Material.graph, attributeNodes = {@NamedAttributeNode("ticket")})
public class Material extends AbstractNamedEntity implements HasId {

    public static final String graph = "Material.withTicket";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "quantity")
    @Range(min = 0, max = 5000)
    private int quantity;

    @NotBlank
    @Column(name = "characteristics")
    @Size(min = 2, max = 120)
    private String characteristics;

    @Column(name = "hasFactoryMarriage")
    private boolean hasFactoryMarriage;

    @Column(name = "marriageDetectionDate")
//  @Range(min = 0, max = 50)
    private LocalDate marriageDetectionDate;

    @Column(name = "marriageDetectedBy")
    @Size(min = 2, max = 128)
    private String marriageDetectedBy;

    @Column(name = "marriageDescription")
    @Size(max = 120)
    private String marriageDescription;

    @Column(name = "marriagePhotoUrl")
    @Size(max = 150)
    private String marriagePhotoUrl;

    @Transient
    private boolean flagToDelete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Ticket ticket;

    public Material() {
    }

    public Material(Integer id, String name, int quantity, String characteristics, boolean hasFactoryMarriage, String marriageDescription) {
        super(name);
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.characteristics = characteristics;
        this.hasFactoryMarriage = hasFactoryMarriage;
        this.marriageDescription = marriageDescription;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isHasFactoryMarriage() {
        return hasFactoryMarriage;
    }

    public String getBroke() {
        if (hasFactoryMarriage) {
            return "Да";
        } else
            return "Нет";
    }

    public void setHasFactoryMarriage(boolean hasFactoryMarriage) {
        this.hasFactoryMarriage = hasFactoryMarriage;
    }

    public LocalDate getMarriageDetectionDate() {
        return marriageDetectionDate;
    }

    public void setMarriageDetectionDate(LocalDate marriageDetectionDate) {
        this.marriageDetectionDate = marriageDetectionDate;
    }

    public String getMarriageDetectedBy() {
        return marriageDetectedBy;
    }

    public void setMarriageDetectedBy(String marriageDetectedBy) {
        this.marriageDetectedBy = marriageDetectedBy;
    }

    public String getMarriageDescription() {
        return marriageDescription;
    }

    public void setMarriageDescription(String marriageDescription) {
        this.marriageDescription = marriageDescription;
    }

    public String getMarriagePhotoUrl() {
        return marriagePhotoUrl;
    }

    public void setMarriagePhotoUrl(String marriagePhotoUrl) {
        this.marriagePhotoUrl = marriagePhotoUrl;
    }

    public boolean isFlagToDelete() {
        return flagToDelete;
    }

    public void setFlagToDelete(boolean flagToDelete) {
        this.flagToDelete = flagToDelete;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void detectFactoryMarriage(boolean hasFactoryMarriage, LocalDate marriageDetectionDate, String marriageDetectedBy,
                                      String marriageDescription, String marriagePhotoUrl) {
        this.hasFactoryMarriage = hasFactoryMarriage;
        this.marriageDetectionDate = marriageDetectionDate;
        this.marriageDetectedBy = marriageDetectedBy;
        this.marriageDescription = marriageDescription;
        this.marriagePhotoUrl = marriagePhotoUrl;
    }

    @Override
    public String toString() {
        String ticketId;
        if (ticket == null) {
            ticketId = "null";
        } else {
            if (ticket.getId() == null) {
                ticketId = "null";
            } else {
                ticketId = ticket.getId().toString();
            }
        }
        return "Material{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", characteristics='" + characteristics + '\'' +
                ", hasFactoryMarriage=" + hasFactoryMarriage +
                ", marriageDetectionDate=" + marriageDetectionDate +
                ", marriageDetectedBy='" + marriageDetectedBy + '\'' +
                ", marriageDescription='" + marriageDescription + '\'' +
                ", marriagePhotoUrl='" + marriagePhotoUrl + '\'' +
                ", ticketId=" + ticketId +
                ", name='" + name + '\'' +
                '}';
    }
}
