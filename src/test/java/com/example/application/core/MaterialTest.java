package com.example.application.core;

import static org.junit.jupiter.api.Assertions.*;

import com.example.application.model.Material;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {ApplicationConfig.class})
@Component
@TestPropertySource(locations = "classpath:application-context.xml")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Material.class })
public class MaterialTest {

    @Autowired
    private Material material;

    @Test
    void testMaterial() {
        assertEquals("Steel", material.getName());
        assertEquals(100, material.getQuantity());
        assertEquals("Alloy", material.getCharacteristics());
    }

    @Test
    void testMaterialSetters() {
        Material material = new Material("", 0, "");
        String name = "Steel";
        int quantity = 100;
        String characteristics = "Alloy";
        material.setName(name);
        material.setQuantity(quantity);
        material.setCharacteristics(characteristics);
        assertEquals(name, material.getName());
        assertEquals(quantity, material.getQuantity());
        assertEquals(characteristics, material.getCharacteristics());
    }
}
