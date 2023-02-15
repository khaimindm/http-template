package com.epam.izh.rd.online.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.epam.izh.rd.online.entity.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Сервис по загрузке данных покемонов из внешнего сервиса
 */
public interface PokemonFetchingService {

    /**
     * @param name - имя покемона
     * @return сущность Pokemon
     * @throws IllegalArgumentException при условии, если имя покемона указано неверно
     * @throws JsonProcessingException
     */
    Pokemon fetchByName(String name) throws IllegalArgumentException, JsonProcessingException;

    /**
     * @param name - имя покемона
     * @return картинка покемона в виде массива байтов
     * @throws IllegalArgumentException при условии, если имя покемона указано неверно
     * @throws JsonProcessingException
     * @throws JsonMappingException
     * @throws MalformedURLException
     * @throws IOException
     */
    byte[] getPokemonImage(String name) throws IllegalArgumentException, JsonMappingException, JsonProcessingException, MalformedURLException, IOException;
}
