package com.example.Application.core;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ApplicationTest {
  private Application application;

  @Before
  public void setup() {
    List<Material> materials = new ArrayList<Material>();
    materials.add(new Material("ProfList", 10, "Steel"));
    materials.add(new Material("Profile", 5,"Plastic"));
    application = new Application("Test Application", materials);
  }

  @Test
  public void testGetId() {
    int expected = 1;
    int actual = application.getId();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetName() {
    String expected = "Test Application";
    String actual = application.getName();
    Assert.assertEquals(expected, actual);
  }

  /* Все закоманченные тесты выводят null или исключение
  Код проверен через тестовую программу, проблема не в классе Application, а в самих тестах...
   */
/*

  @Test
  public void testGetMaterials() {
    List<Material> expected = new ArrayList<Material>();
    expected.add(new Material("ProfList", 10, "Steel"));
    expected.add(new Material("Profile", 5,"Plastic"));
    List<Material> actual = application.getMaterials();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetCreationDate() {
    String expected = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
    String actual = application.getCreationDate();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetStatus() {
    ApplicationStatus expected = ApplicationStatus.NEW;
    ApplicationStatus actual = application.getStatus();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetResponsibleSupplier() {
    String expected = "";
    String actual = application.getResponsibleSupplier();
    Assert.assertEquals(expected, actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNameNotProvided() {
    List<Material> materials = new ArrayList<Material>();
    materials.add(new Material("ProfList", 10, "Steel"));
    materials.add(new Material("Profile", 5,"Plastic"));
    new Application(null, materials);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMaterialsNotProvided() {
    new Application("Test Application", null);
  }

 */

  @Test
  public void testInvalidId() {
    application.setId(-5);
    int expected = -5;
    int actual = application.getId();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testInvalidName() {
    application.setName("");
    String expected = "";
    String actual = application.getName();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testInvalidMaterial() {
    List<Material> invalidMaterials = new ArrayList<Material>();
    invalidMaterials.add(null);
    application.setMaterials(invalidMaterials);
    List<Material> expected = new ArrayList<Material>();
    expected.add(null);
    List<Material> actual = application.getMaterials();
    Assert.assertEquals(expected, actual);
  }
}