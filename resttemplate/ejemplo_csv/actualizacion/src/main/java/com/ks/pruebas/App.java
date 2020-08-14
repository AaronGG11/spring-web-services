package com.ks.pruebas;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class App
{
    public static void main(String[] args) throws IOException, CsvValidationException
    {
        //SpringApplication app = new SpringApplication(App.class, args);
        SpringApplication.run(App.class, args);
        actualiza();
    }

    static public void actualiza() throws IOException, CsvValidationException
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        CSVReader reader = new CSVReader(new FileReader("actualizacion.csv"));

        // read line by line
        String[] record = null;

        while ((record = reader.readNext()) != null)
        {
            String email = record[0];
            String id = record[1];

            String url = "http://localhost:8090/ks/persons/update/prefijo/{id}/byemail/{email}";

            Map<String, String> vars = new HashMap<>();
            vars.put("email", email);

            //find by id
            String url_search = "http://localhost:8090/ks/persons/byemail/{email}";
            Person p1 = restTemplate.getForObject(url_search, Person.class, vars);

            Map<String, String> params = new HashMap();
            params.put("email", email);
            params.put("id", p1.getPrefijo() + id);

            UriComponents uri = UriComponentsBuilder.fromUriString(url)
                    .build()
                    .expand(params)
                    .encode();

            restTemplate.put ( uri.toUriString(), null);
        }
    }
}