package com.example.application.model;

import com.example.application.HasId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractNamedEntity implements HasId {

	@Id
	@Access(AccessType.FIELD)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "creationDate", nullable = false)
	@NotBlank
	private String creationDate;

	@Column(name = "status", nullable = false)
	@NotNull
	private ApplicationStatus status;

	@Column(name = "responsibleSupplier")
	@Size(min = 2, max = 128)
	private String responsibleSupplier;

	@Column(name = "deliveryDate")
	@Size(min = 2, max = 20)
	private String deliveryDate;

	@Column(name = "statusChangeDate")
	@Size(min = 2, max = 20)
	private String statusChangeDate;

	@Column(name = "isClosed")
	private boolean isClosed;

	@Column(name = "closingDate")
	@Size(min = 2, max = 20)
	private String closingDate;

	@Column(name = "closedBy")
	@Size(min = 2, max = 128)
	private String closedBy;

	@Column(name = "objectName")
	private ObjectName objectName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
	@OrderBy("name DESC")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Material> materials;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Ticket(String name, List<Material> materials) {

		int id = this.id++;
		this.name = name;
		this.materials = materials;
		String creationDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
		ApplicationStatus status = ApplicationStatus.NEW;
		User createdBy = user; //user добавлен в конструктор

		String responsibleSupplier = "";
		Date deliveryDate = null;
		Date statusChangeDate = new Date();
		boolean isClosed = false;
		Date closingDate = null;
		String closedBy = " ";
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
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

	public ObjectName getObjectName() {
		return objectName;
	}

	public void setObjectName(ObjectName objectName) {
		this.objectName = objectName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void closeApplication(Date closingDate, String closedBy) {
		setClosed(true);
		setClosingDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(closingDate));
		setClosedBy(closedBy);
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
