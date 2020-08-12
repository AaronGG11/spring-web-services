package com.ks.app.model;

import com.ks.app.model.model.Person;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.*;

@SpringBootApplication
public class App implements CommandLineRunner
{
    public static void main(String[] args) throws IOException, CsvValidationException
    {
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();

        CSVReader reader = new CSVReader(new FileReader("escritura.csv"));

        // read line by line
        String[] record = null;
        // url to service
        String url = "http://localhost:8090/ks/persons";

        while ((record = reader.readNext()) != null) {
            Person persona = new Person();
            persona.setNombre(record[0]);
            persona.setEdad(Integer.parseInt(record[1]));
            persona.setEmail(record[2]);

            restTemplate.postForObject(url,persona,Person.class); // two ways
        }
    }
}


