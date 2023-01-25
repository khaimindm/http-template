package com.epam.izh.rd.online;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class Http {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/ditto/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        System.out.println(response.getBody());
    }
}
