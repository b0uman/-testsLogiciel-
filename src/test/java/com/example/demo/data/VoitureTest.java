package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {
    
    @Test
    void creerVoiture(){
        Voiture v = new Voiture("volvo",1342);
        v.setId(1);
        assertEquals(1,v.getId());
        assertEquals(1342,v.getPrix());
        assertEquals("volvo",v.getMarque());
    }

}
