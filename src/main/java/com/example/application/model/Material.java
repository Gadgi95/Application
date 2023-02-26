package com.example.application.model;

import com.example.application.HasId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "materials")
public class Material extends AbstractNamedEntity implements HasId {

  @Id
  @Access(AccessType.FIELD)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotNull
  @Range(min = 0, max = 5000)
  private int quantity;

  @NotBlank
  @Size(min = 2, max = 120)
  private String characteristics;

  @Column(name = "hasFactoryMarriage")
  private boolean hasFactoryMarriage;

  @Column(name = "marriageDetectionDate")
  @Size(min = 2, max = 20)
  private Date marriageDetectionDate;

  @Column(name = "marriageDetectedBy")
  @Size(min = 2, max = 128)
  private String marriageDetectedBy;

  @Column(name = "marriageDescription")
  @Size(min = 2, max = 120)
  private String marriageDescription;

  @Column(name = "marriagePhotoUrl")
  @Size(min = 2, max = 150)
  private String marriagePhotoUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ticket_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Ticket ticket;

  public Material(String name, int quantity, String characteristics) {
    this.name = name;
    this.quantity = quantity;
    this.characteristics = characteristics;

    boolean hasFactoryMarriage = false;
    Date marriageDetectionDate;
    String marriageDetectedBy;
    String marriageDescription;
    String marriagePhotoUrl;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  public Material() {
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

  public void setHasFactoryMarriage(boolean hasFactoryMarriage) {
    this.hasFactoryMarriage = hasFactoryMarriage;
  }

  public Date getMarriageDetectionDate() {
    return marriageDetectionDate;
  }

  public void setMarriageDetectionDate(Date marriageDetectionDate) {
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

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public void detectFactoryMarriage(Date marriageDetectionDate, String marriageDetectedBy,
                                    String marriageDescription, String marriagePhotoUrl) {
    setHasFactoryMarriage(true);
    setMarriageDetectionDate(marriageDetectionDate);
    setMarriageDetectedBy(marriageDetectedBy);
    setMarriageDescription(marriageDescription);
    setMarriagePhotoUrl(marriagePhotoUrl);
  }

  @Override
  public String toString() {
    return "Material{" +
            "id=" + id +
            ", quantity=" + quantity +
            ", characteristics='" + characteristics + '\'' +
            ", hasFactoryMarriage=" + hasFactoryMarriage +
            ", marriageDetectionDate=" + marriageDetectionDate +
            ", marriageDetectedBy='" + marriageDetectedBy + '\'' +
            ", marriageDescription='" + marriageDescription + '\'' +
            ", marriagePhotoUrl='" + marriagePhotoUrl + '\'' +
            ", ticket=" + ticket +
            ", name='" + name + '\'' +
            '}';
  }
}
