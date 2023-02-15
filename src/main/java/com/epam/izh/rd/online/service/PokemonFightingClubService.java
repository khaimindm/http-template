package com.epam.izh.rd.online.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.epam.izh.rd.online.entity.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Сервис по проведению боёв между покемонами
 */
public interface PokemonFightingClubService {

    /**
     * Инициирует бой между двумя покемонами, должен использовать метод doDamage
     * @param p1 атакующий покемон
     * @param p2 защищающийся покемон
     * @return победителя
     */
    Pokemon doBattle(Pokemon p1, Pokemon p2);

    /**
     * Метод загружает картинку победителя в корень проекта
     * @param winner победитель
     * @throws IOException
     * @throws MalformedURLException
     * @throws IllegalArgumentException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    void showWinner(Pokemon winner) throws JsonMappingException, JsonProcessingException, IllegalArgumentException, MalformedURLException, IOException;

    /**
     * Метод высчитывает урон покемона from и вычитает его из hp покемона to
     * @param from атакующий покемон
     * @param to защищающийся покемон
     */
    void doDamage(Pokemon from, Pokemon to);
}
