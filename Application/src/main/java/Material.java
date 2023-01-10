package main.java;

public class Material {

  private String name;
  private int quantity;
  private String characteristics;

  public Material(String name, int quantity, String characteristics) {
    this.name = name;
    this.quantity = quantity;
    this.characteristics = characteristics;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


}
