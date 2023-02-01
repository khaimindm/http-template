package com.epam.izh.rd.online;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Scanner;

public class Http {
    public static void main(String[] args) {
        System.out.println("Введите имя первого покемона (например: pikachu, ditto... Список всех имен можно найти на https://pokeapi.co/):");
        Scanner scanner = new Scanner(System.in);
        String nameOfFirstPokemon = scanner.nextLine();

        System.out.println("Введите имя второго покемона (например: pikachu, ditto... Список всех имен можно найти на https://pokeapi.co/):");
        String nameOfSecondPokemon = scanner.nextLine();

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

        scanner.close();
    }
}
