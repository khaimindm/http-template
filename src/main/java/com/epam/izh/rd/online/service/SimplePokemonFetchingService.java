package com.epam.izh.rd.online.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.ObjectMapperFactory;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class SimplePokemonFetchingService implements  PokemonFetchingService{
    private ObjectMapperFactory objectMapperFactory;
    
    public SimplePokemonFetchingService(ObjectMapperFactory objectMapperFactory) {
        this.objectMapperFactory = objectMapperFactory;
    }

    RestTemplate restTemplate = new RestTemplate();    
    HttpHeaders headers = new HttpHeaders();
    Stats stats = new Stats();

    @Override
    public Pokemon fetchByName(String name) throws IllegalArgumentException, JsonMappingException, JsonProcessingException {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        headers.set("User-Agent", "");
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);


        String responseBody = response.getBody();
        //System.out.println(responseBody);
        //JsonNode obj = objectMapperFactory.getObjectMapper().readTree(response.toString());
        //Pokemon pokemon = new Pokemon();
        //pokemon.setPokemonId(obj.get("held_items").get("id").asLong());

        /*Stat stat = objectMapperFactory.getObjectMapper().
                readerFor(Stat.class).
                readValue(String.valueOf(response));*/
        //String responseString = String.valueOf(response);
        //System.out.println(response);

        //List<Stat> statList = new ArrayList<>();

        JsonNode obj = objectMapperFactory.getObjectMapper().readTree(responseBody);
        String statsString = String.valueOf(obj.get("stats"));
        int size = obj.get("stats").size();
        System.out.println(size);

        StatsArray statsArray = objectMapperFactory.getObjectMapper().readValue(statsString, StatsArray.class);
        
        System.out.println(statsArray);
        


        Stats stats = objectMapperFactory.getObjectMapper().readValue(statsString, Stats.class);

        //Stat stat = objectMapperFactory.getObjectMapper().readValue(String.valueOf(obj.get("stats").get(0)), Stat.class);
        //System.out.println(stat);
        return null;
    }

    @Override
    public byte[] getPokemonImage(String name) throws IllegalArgumentException {
        return new byte[0];
    }
}
