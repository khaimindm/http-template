package com.epam.izh.rd.online.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.epam.izh.rd.online.entity.Pokemon;
import com.epam.izh.rd.online.factory.ObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class SimplePokemonFightingClubService implements PokemonFightingClubService {
    private ObjectMapperFactory objectMapperFactory;
    
    public SimplePokemonFightingClubService(ObjectMapperFactory objectMapperFactory) {
        this.objectMapperFactory = objectMapperFactory;
    }

    Pokemon pokemonWinner;

    @Override
    public Pokemon doBattle(Pokemon p1, Pokemon p2) {
        doDamage(p1, p2);
        if(p2.getHp() <= 0) {
            pokemonWinner = p1;                  
        } else if(p1.getHp() <= 0 && p2.getHp() >= 0) {
            pokemonWinner = p2;
        } else {
            doBattle(p2, p1);
        }
        
        return pokemonWinner;
    }

    @Override
    public void showWinner(Pokemon winner) throws JsonMappingException, JsonProcessingException, IllegalArgumentException, MalformedURLException, IOException {
        PokemonFetchingService pokemonFetchingService = new SimplePokemonFetchingService(objectMapperFactory);
        pokemonFetchingService.getPokemonImage(winner.getPokemonName());
    }

    @Override
    public void doDamage(Pokemon from, Pokemon to) {
        int damage = from.getAttack() - (from.getAttack() * to.getDefense() / 100);
        from.setHp((short) (from.getHp() - damage));
        to.setHp((short) (to.getHp() - damage));         
    }
}
