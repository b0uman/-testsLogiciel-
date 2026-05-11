package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getStatOk(){
        when(statistiqueImpl.getPrixMoyen()).thenReturn(new Echantillon(4,900));

        mockMvc.perform(get("/statistique").andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.nombreDeVoitures").value(4))
        .andExpect(jsonPath("$.prixMoyen").value(900)));
    }

    @Test 
    void getStatNull() throws Exception{
        when(statistique.prixMoyen()).thenThrow(new ArithmeticException());

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreerVoiture() throws Exception {
        Voiture nouvelleVoiture = new Voiture("Tesla", 50000);
        ObjectMapper mapper = new ObjectMapper();

        String jsonVoiture = mapper.writeValueAsString(nouvelleVoiture);
    
        mockMvc.perform(post("/voiture")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonVoiture))
            .andExpect(status().isOk());
    }
    

}
