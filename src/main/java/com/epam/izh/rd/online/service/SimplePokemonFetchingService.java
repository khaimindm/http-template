package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Pokemon;

public class SimplePokemonFetchingService implements  PokemonFetchingService{
    @Override
    public Pokemon fetchByName(String name) throws IllegalArgumentException {
        return null;
    }

    @Override
    public byte[] getPokemonImage(String name) throws IllegalArgumentException {
        return new byte[0];
    }
}
