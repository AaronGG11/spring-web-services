package com.ks.pruebas.app;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App
{
    public static void main(String[] args) throws IOException, CsvValidationException
    {
        SpringApplication.run(App.class, args);
        actualiza();
    }

    static public void actualiza()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/ks/persons/pairs";

		// delete
		restTemplate.delete(url); // there are more methods

    }
}