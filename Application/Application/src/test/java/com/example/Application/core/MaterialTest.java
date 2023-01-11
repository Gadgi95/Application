package com.example.Application.core;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class MaterialTest {
  private Material material;

  @Before
  public void setup() {
    material = new Material("Steel", 10, "High strength");
  }

  @Test
  public void testGetName() {
    String expected = "Steel";
    String actual = material.getName();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetQuantity() {
    int expected = 10;
    int actual = material.getQuantity();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetCharacteristics() {
    String expected = "High strength";
    String actual = material.getCharacteristics();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSetName() {
    material.setName("Aluminum");
    String expected = "Aluminum";
    String actual = material.getName();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSetQuantity() {
    material.setQuantity(20);
    int expected = 20;
    int actual = material.getQuantity();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSetCharacteristics() {
    material.setCharacteristics("Lightweight");
    String expected = "Lightweight";
    String actual = material.getCharacteristics();
    Assert.assertEquals(expected, actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidName() {
    material.setName(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidQuantity() {
    material.setQuantity(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCharacteristics() {
    material.setCharacteristics(null);
  }
}
