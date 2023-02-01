package com.epam.izh.rd.online.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.ObjectMapperFactory;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public class SimplePokemonFetchingService implements  PokemonFetchingService{
    private ObjectMapperFactory objectMapperFactory;
    
    public SimplePokemonFetchingService(ObjectMapperFactory objectMapperFactory) {
        this.objectMapperFactory = objectMapperFactory;
    }

    RestTemplate restTemplate = new RestTemplate();    
    HttpHeaders headers = new HttpHeaders();

    @Override
    public Pokemon fetchByName(String name) throws IllegalArgumentException, JsonMappingException, JsonProcessingException {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        headers.set("User-Agent", "");
        HttpEntity<String> request = new HttpEntity<>(headers);         
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);              
        JsonNode obj = objectMapperFactory.getObjectMapper().readTree(response.toString());
        Pokemon pokemon = new Pokemon();        
        pokemon.setPokemonId(obj.get("held_items").get("id").asLong());
        
        return null;
    }

    @Override
    public byte[] getPokemonImage(String name) throws IllegalArgumentException {
        return new byte[0];
    }
}
