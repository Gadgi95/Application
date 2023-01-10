import java.util.Date;
import java.util.List;

public class Application {

  private int id;
  private String name;
  private List<Material> materials;
  private Date creationDate;
  private ApplicationStatus status;
  private String responsibleSupplier;
  private Date deliveryDate;
  private Date statusChangeDate;
  private boolean isClosed;
  private Date closingDate;
  private String closedBy;
  private boolean hasFactoryMarriage;
  private Date marriageDetectionDate;
  private String marriageDetectedBy;
  private String marriageDescription;
  private String marriagePhotoUrl;

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

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
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

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public Date getStatusChangeDate() {
    return statusChangeDate;
  }

  public void setStatusChangeDate(Date statusChangeDate) {
    this.statusChangeDate = statusChangeDate;
  }

  public boolean isClosed() {
    return isClosed;
  }

  public void setClosed(boolean closed) {
    isClosed = closed;
  }

  public Date getClosingDate() {
    return closingDate;
  }

  public void setClosingDate(Date closingDate) {
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
    setClosingDate(closingDate);
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
}