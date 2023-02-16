package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.ObjectMapperFactory;
import com.epam.izh.rd.online.factory.SimpleObjectMapperFactory;
import com.epam.izh.rd.online.service.PokemonFetchingService;
import com.epam.izh.rd.online.service.PokemonFightingClubService;
import com.epam.izh.rd.online.service.SimplePokemonFetchingService;
import com.epam.izh.rd.online.service.SimplePokemonFightingClubService;
import java.io.IOException;

public class Http {
    public static void main(String[] args) throws IOException {
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
