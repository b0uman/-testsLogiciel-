package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @BeforeEach
    void setUp() {
        statistiqueImpl = new StatistiqueImpl();
    }

    @Test
    void ajouter_ShouldIncreaseListSize() {
        Voiture v1 = new Voiture(15000);
        statistiqueImpl.ajouter(v1);
        Echantillon result = statistiqueImpl.prixMoyen();
        assertThat(result.getNombreDeVoitures()).isEqualTo(1);
    }

    @Test
    void prixMoyen_ShouldCalculateCorrectAverage() {
        statistiqueImpl.ajouter(new Voiture("treter",10000));
        statistiqueImpl.ajouter(new Voiture("JHDPZ",20000));
        statistiqueImpl.ajouter(new Voiture("DDHZUHD",30000));

        Echantillon result = statistiqueImpl.prixMoyen();

        assertThat(result.getNombreDeVoitures()).isEqualTo(3);
        assertThat(result.getPrixMoyen()).isEqualTo(20000);
    }

    @Test
    void prixMoyen_WithEmptyList_ShouldThrowArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            statistiqueImpl.prixMoyen();
        }, "Une division par zéro devrait lever une ArithmeticException");
    }


}
