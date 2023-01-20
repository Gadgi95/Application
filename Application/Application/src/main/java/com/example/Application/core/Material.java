package com.example.Application.core;

import com.example.Application.model.AbstractNamedEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "materials")
public class Material extends AbstractNamedEntity {

  @NotNull
  @Range(min = 0, max = 5000)
  private int quantity;

  @NotBlank
  @Size(min = 2, max = 120)
  private String characteristics;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ticket_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Ticket ticket;

  public Material(String name, int quantity, String characteristics) {
    this.name = name;
    this.quantity = quantity;
    this.characteristics = characteristics;
  }

  public Material() {
  }

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
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

  @Override
  public String toString() {
    return "Material{" +
            "quantity=" + quantity +
            ", characteristics='" + characteristics + '\'' +
            ", ticket=" + ticket +
            ", id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
