package com.example.Application.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

	private int id = 0;
	private String name;
	private List<Material> materials;
	private String creationDate;
	private ApplicationStatus status;
	private String responsibleSupplier;
	private String deliveryDate;
	private String statusChangeDate;
	private boolean isClosed;
	private String closingDate;
	private String closedBy;
	private boolean hasFactoryMarriage;
	private Date marriageDetectionDate;
	private String marriageDetectedBy;
	private String marriageDescription;
	private String marriagePhotoUrl;

	public Application(String name, List<Material> materials) {

		int id = this.id++;
		this.name = name;
		this.materials = materials;

		String creationDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
		ApplicationStatus status = ApplicationStatus.NEW;
		String responsibleSupplier = "";
		Date deliveryDate = null;
		Date statusChangeDate = new Date();
		boolean isClosed = false;
		Date closingDate = null;
		String closedBy = " ";
		boolean hasFactoryMarriage = false;
		Date marriageDetectionDate;
		String marriageDetectedBy;
		String marriageDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public boolean hasFactoryMarriage() {
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

	public void closeApplication(Date closingDate, String closedBy) {
		setClosed(true);
		setClosingDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(closingDate));
		setClosedBy(closedBy);
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
				", hasFactoryMarriage=" + hasFactoryMarriage +
				", marriageDetectionDate=" + marriageDetectionDate +
				", marriageDetectedBy='" + marriageDetectedBy + '\'' +
				", marriageDescription='" + marriageDescription + '\'' +
				", marriagePhotoUrl='" + marriagePhotoUrl + '\'' +
				'}';
	}

}
