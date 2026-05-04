package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {
    @BeforeEach
    void init(){
        Voiture v = new Voiture("volvo",1342);
    }

    @Test
    void creerVoiture(){
        v.setId(1);
        assertEquals(1,v.getId());
        assertEquals(1342,v.getPrix());
        assertEquals("volvo",v.getMarque());
    }

}
