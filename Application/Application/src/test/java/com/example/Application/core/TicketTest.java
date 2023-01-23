package com.example.Application.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.Application.core.Ticket;
import com.example.Application.core.Material;
import com.example.Application.model.ObjectName;
import com.example.Application.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
@TestPropertySource(locations = "classpath:application-context.xml")
public class TicketTest {

    ArrayList<Material> materials;
    Material material;

    @Before
    public void setup() {
        materials.add(new Material("Картон", 1, "цветной"));
        materials.add(new Material("Дерево", 2, "деревянное"));
        materials.add(new Material("Железо", 3, "хром"));
    }

    @Test
    public void testGetId() {
        Ticket ticket = new Ticket("Ticket1", materials);
//        assertEquals(0, ticket.getId());
    }

    @Test
    public void testSetId() {
        Ticket ticket = new Ticket("Ticket1", materials);
        ticket.setId(1);
//        assertEquals(1, ticket.getId());
    }

    @Test
    public void testGetName() {
        Ticket ticket = new Ticket("Ticket1", materials);
        assertEquals("Ticket1", ticket.getName());
    }

    @Test
    public void testSetName() {
        Ticket ticket = new Ticket("Ticket1", materials);
        ticket.setName("Ticket2");
        assertEquals("Ticket2", ticket.getName());
    }

//    @Test
//    public void testGetCreationDate() {
//        Ticket ticket = new Ticket("Ticket1", materials);
//        assertEquals(new Date().getTime(), ticket.getCreationDate().getTime(), 1000);
//    }

    @Test
    public void testGetMaterials() {
        ArrayList<Material> materials = new ArrayList<Material>();
        materials.add(new Material("Material1", 1, " "));
        materials.add(new Material("Material2", 3, " "));
        Ticket ticket = new Ticket("Ticket1", materials);
        assertEquals(materials, ticket.getMaterials());
    }

    @Test
    public void testSetMaterials() {
        ArrayList<Material> materials = new ArrayList<Material>();
        materials.add(new Material("Material1", 1, " "));
        materials.add(new Material("Material2", 3, " "));
        Ticket ticket = new Ticket("Ticket1", materials);
        ticket.setMaterials(materials);
        assertEquals(materials, ticket.getMaterials());
    }
}
