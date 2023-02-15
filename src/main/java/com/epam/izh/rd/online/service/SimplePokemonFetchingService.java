package com.epam.izh.rd.online.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.ObjectMapperFactory;
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
        String responseBody = response.getBody();

        JsonNode obj = objectMapperFactory.getObjectMapper().readTree(responseBody);
        String statsString = String.valueOf(obj.get("stats"));

        Stats[] stats = objectMapperFactory.getObjectMapper().readValue(statsString, Stats[].class);

        Pokemon pokemon = new Pokemon();
        pokemon.setPokemonId(obj.get("id").asLong());
        pokemon.setPokemonName(obj.get("name").asText());

        for (Stats eStats : stats) {            
            if(eStats.getStat().getName().equals("hp")) {
                pokemon.setHp(eStats.getBaseStat());
                break;
            }
        }

        for (Stats eStats : stats) {
            if(eStats.getStat().getName().equals("attack")) {
                pokemon.setAttack(eStats.getBaseStat());
                break;
            }            
        }

        for (Stats eStats : stats) {
            if(eStats.getStat().getName().equals("defense")) {
                pokemon.setDefense(eStats.getBaseStat());
                break;
            }            
        }
        
        return pokemon;
    }

    @Override
    public byte[] getPokemonImage(String name) throws IllegalArgumentException, IOException {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        headers.set("User-Agent", "");
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        String responseBody = response.getBody();

        JsonNode obj = objectMapperFactory.getObjectMapper().readTree(responseBody);
        String pokemonImageUrl = String.valueOf(obj.get("sprites").get("front_default"));
        
        System.out.println(pokemonImageUrl);

        URL imageUrl = new URL(pokemonImageUrl);
        BufferedImage bImage = ImageIO.read(imageUrl);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", baos);
        byte[] data = baos.toByteArray();
        
        return data;
    }
}
