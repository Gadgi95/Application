package com.example.application.model;

import com.example.application.HasId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractNamedEntity implements HasId {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "creationDate", nullable = false, columnDefinition = "datetime default now()", updatable = false)
	@NotNull
	private LocalDateTime creationDate = LocalDateTime.now();

	@Column(name = "status", nullable = false)
	@NotBlank
	@Size(min = 2, max = 30)
	private String status;

	@Column(name = "responsibleSupplier")
	@Size(min = 2, max = 128)
	private String responsibleSupplier;

	@Column(name = "deliveryDate")
	@Size(min = 2, max = 20)
	private String deliveryDate;

	@Column(name = "statusChangeDate")
	@Size(min = 2, max = 20)
	private String statusChangeDate;

	@Column(name = "isClosed", nullable = false)
	@NotNull
	private boolean isClosed;

	@Column(name = "closingDate")
	@Size(min = 2, max = 20)
	private String closingDate;

	@Column(name = "closedBy")
	@Size(min = 2, max = 128)
	private String closedBy;

	@Column(name = "objectName")
	@Size(min = 2, max = 128)
	private String objectName;

	@OneToMany(mappedBy = "ticket")
	@LazyCollection(LazyCollectionOption.TRUE)
	@OrderBy("name DESC")
	@BatchSize(size = 100)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Material> materials;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@BatchSize(size = 50)
	@JsonIgnore
	private User user;

	public Ticket(Integer id, String name, LocalDateTime creationDate, String status, String responsibleSupplier, String deliveryDate,
				  String statusChangeDate, boolean isClosed, String closingDate, String closedBy,
				  String objectName) {
		super(name);
		this.id = id;
		this.creationDate = creationDate;
		this.status = status;
		this.responsibleSupplier = responsibleSupplier;
		this.deliveryDate = deliveryDate;
		this.statusChangeDate = statusChangeDate;
		this.isClosed = isClosed;
		this.closingDate = closingDate;
		this.closedBy = closedBy;
		this.objectName = objectName;
	}
	public Ticket(Integer id, String name, String status, boolean isClosed, String objectName) {
		super(name);
		this.id = id;
		this.status = status;
		this.isClosed = isClosed;
		this.objectName = objectName;
	}
	public Ticket() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponsibleSupplier() {
		return responsibleSupplier;
	}

	public void setResponsibleSupplier(String responsibleSupplier) {
		this.responsibleSupplier = responsibleSupplier;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatusChangeDate() {
		return statusChangeDate;
	}

	public void setStatusChangeDate(String statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean closed) {
		isClosed = closed;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	public String getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "main.java.Application{" +
				"id=" + id +
				", name='" + name + '\'' +
				", materials=" + materials +
				", creationDate=" + creationDate +
				", status=" + status +
				", responsibleSupplier='" + responsibleSupplier + '\'' +
				", deliveryDate=" + deliveryDate +
				", statusChangeDate=" + statusChangeDate +
				", isClosed=" + isClosed +
				", closingDate=" + closingDate +
				", closedBy='" + closedBy + '\'' +
				'}';
	}
}
