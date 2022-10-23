package com.fictious.app.cloudnativedemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AppControllerTest {
    @Autowired
    AppController appController;

    @Test
    void nationsLength() {
        Integer nationsLength = appController.getRandomNations().size();
        assertEquals(10, nationsLength);
    }

    @Test
    void currenciesLength() {
        Integer currenciesLength = appController.getRandomCurrencies().size();
        assertEquals(20, currenciesLength);
    }

    @Test
    void personsLength() {
        Integer personsLength = appController.getRandomPersons().size();
        assertEquals(10, personsLength);
    }
}
