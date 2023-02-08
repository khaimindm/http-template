package com.epam.izh.rd.online;

import com.epam.izh.rd.online.factory.ObjectMapperFactory;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;
import com.epam.izh.rd.online.service.PokemonFetchingService;
import com.epam.izh.rd.online.service.SimplePokemonFetchingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Scanner;

public class Http {
    public static void main(String[] args) throws JsonProcessingException {
        //RestTemplate restTemplate = new RestTemplate();
        //String urlFirstPokemon = "https://pokeapi.co/api/v2/pokemon/" + nameOfFirstPokemon;
        //String urlSecondPokemon = "https://pokeapi.co/api/v2/pokemon/" + nameOfSecondPokemon;
        //HttpHeaders headers = new HttpHeaders();
        //headers.set("User-Agent", "");

        //HttpEntity<String> request = new HttpEntity<>(headers);

        //ResponseEntity<String> responseFirstPokemon = restTemplate.exchange(urlFirstPokemon, HttpMethod.GET, request, String.class);
        //ResponseEntity<String> responseSecondPokemon = restTemplate.exchange(urlSecondPokemon, HttpMethod.GET, request, String.class);
        
        //System.out.println("Первый покемон");
        //System.out.println(responseFirstPokemon.getBody());

        //System.out.println("Второй покемон");
        //System.out.println(responseSecondPokemon.getBody());

        String pokemonName1 = "slowpoke";
        ObjectMapperFactory objectMapperFactory = new SimpleObjectMapperFactory();
        PokemonFetchingService pokemonFetchingService = new SimplePokemonFetchingService(objectMapperFactory);

        pokemonFetchingService.fetchByName(pokemonName1);
    }
}
