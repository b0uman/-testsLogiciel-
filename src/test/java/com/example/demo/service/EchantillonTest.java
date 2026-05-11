package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EchantillonTest {

    private Echantillon e;

    @BeforeEach
    public void init(){
        e = new Echantillon(1000,9000);
    }

    @Test
    void nombreVoitureTest(){
        assertEquals(1000, e.getNombreDeVoitures());
    }

    @Test 
    void prixMoyenTest(){
        assertEquals(9000, e.getPrixMoyen());
    }

    @Test
    void setNombreVoitureTest(){
        e.setNombreDeVoitures(8);
        assertEquals(8, e.getNombreDeVoitures());
    }

    @Test 
    void setPrixMoyenTest(){
        e.setPrixMoyen(3);
        assertEquals(3, e.getPrixMoyen());
    }


}
