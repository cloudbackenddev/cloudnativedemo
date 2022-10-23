package com.fictious.app.cloudnativedemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class AppController {
    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var nations = objectMapper.createArrayNode();
        for (var i = 0; i < 10; i++) {
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
                    .put("nationality", nation.nationality())
                    .put("capitalCity", nation.capitalCity())
                    .put("flag", nation.flag())
                    .put("language", nation.language()));
        }
        return nations;
    }

    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var currencies = objectMapper.createArrayNode();
        for (var i = 0; i < 20; i++) {
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
                    .put("name", currency.name())
                    .put("code", currency.code()));
        }
        return currencies;

    }

    @GetMapping("/persons")
    public JsonNode getRandomPersons() {
        Faker faker = new Faker();
        var objectMapper = new ObjectMapper();
        ArrayNode persons = objectMapper.createArrayNode();

        for (int i = 0; i < 10; i++) {
            persons.add(objectMapper.createObjectNode()
                    .put("firstName", faker.name().firstName())
                    .put("lastName", faker.name().lastName())
                    .put("title", faker.name().title())
                    .put("suffix", faker.name().suffix())
                    .put("address", faker.address().streetAddress())
                    .put("city", faker.address().cityName())
                    .put("country", faker.address().country()));
        }
        return persons;
    }
}
