package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.ObjectMapperFactory;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;
import com.epam.izh.rd.online.service.PokemonFetchingService;
import com.epam.izh.rd.online.service.PokemonFightingClubService;
import com.epam.izh.rd.online.service.SimplePokemonFetchingService;
import com.epam.izh.rd.online.service.SimplePokemonFightingClubService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Http {
    public static void main(String[] args) throws IOException {
        //RestTemplate restTemplate = new RestTemplate();
        //String urlFirstPokemon = "https://pokeapi.co/api/v2/pokemon/" + nameOfFirstPokemon;
        //String urlSecondPokemon = "https://pokeapi.co/api/v2/pokemon/" + nameOfSecondPokemon;
        //HttpHeaders headers = new HttpHeaders();
        //headers.set("User-Agent", "");

        //HttpEntity<String> request = new HttpEntity<>(headers);

        //ResponseEntity<String> responseFirstPokemon = restTemplate.exchange(urlFirstPokemon, HttpMethod.GET, request, String.class);
        //ResponseEntity<String> responseSecondPokemon = restTemplate.exchange(urlSecondPokemon, HttpMethod.GET, request, String.class);

        
        String pokemonName1 = "pikachu";
        String pokemonName2 = "slowpoke";

        ObjectMapperFactory objectMapperFactory = new SimpleObjectMapperFactory();
        PokemonFetchingService pokemonFetchingService = new SimplePokemonFetchingService(objectMapperFactory);
        PokemonFightingClubService pokemonFightingClubService = new SimplePokemonFightingClubService(objectMapperFactory);

        Pokemon pokemon1 = pokemonFetchingService.fetchByName(pokemonName1);
        Pokemon pokemon2 = pokemonFetchingService.fetchByName(pokemonName2);

        Pokemon pokemonWinner;

        if (pokemon1.getPokemonId() >= pokemon2.getPokemonId()) {
            pokemonWinner = pokemonFightingClubService.doBattle(pokemon1, pokemon2);            
        } else {
            pokemonWinner = pokemonFightingClubService.doBattle(pokemon2, pokemon1);
        }

        pokemonFightingClubService.showWinner(pokemonWinner);

        System.out.println("Pokemon winner: " + pokemonWinner.getPokemonName());
    }
}
