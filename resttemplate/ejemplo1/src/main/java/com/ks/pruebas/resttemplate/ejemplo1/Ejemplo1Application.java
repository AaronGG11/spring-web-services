package com.ks.pruebas.resttemplate.ejemplo1;

import com.google.gson.Gson;
import com.ks.pruebas.resttemplate.ejemplo1.model.Person;
import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Builder

@SpringBootApplication
public class Ejemplo1Application implements CommandLineRunner
{

	public static void main(String[] args)
	{
		SpringApplication app = new SpringApplication(Ejemplo1Application.class);
		app.run(args);
	}


	@Override
	public void run(String... args) throws Exception
	{
		RestTemplate restTemplate = new RestTemplate();

		/*
		// salute
		String resultado = restTemplate.getForObject("http://localhost:8090/ks/inicio", String.class);
		System.out.println(resultado);
		*/

		/*
		//find by id
		Integer id_search = 1;
		String url = "http://localhost:8090/ks/persons/" + id_search;
		Person p1 = restTemplate.getForObject(url, Person.class);
		System.out.println(p1.toString());
		*/

		/*
		// add a person
		Person p2 = new Person();
		p2.setNombre("Saul");
		p2.setEdad(45);
		p2.setEmail("srivas@gmail.com");

		String url = "http://localhost:8090/ks/persons";
		URI uri = new URI(url);

		//ResponseEntity<Person> result = restTemplate.postForEntity(uri,p2,Person.class);
		restTemplate.postForObject(url,p2,Person.class); // two ways
		*/

		/*
		// delete a person by id
		Integer id_search = 1;
		String url = "http://localhost:8090/ks/persons/" + id_search;

		restTemplate.delete(url); // there are more methods
		*/

		/*
		// update a person
		String url = "http://localhost:8090/ks/persons";
		URI uri = new URI(url);

		Person p2 = new Person();
		p2.setID(3);
		p2.setNombre("Saul");
		p2.setEdad(45);
		p2.setEmail("srivas@gmail.com");

		restTemplate.put(uri,p2);
		*/

		// find all people
		String url = "http://localhost:8090/ks/persons";

		ResponseEntity<Person[]> responseEntity = restTemplate.getForEntity(url, Person[].class);
		List<Person> people = Arrays.asList(responseEntity.getBody());

		Gson gson = new Gson();
		people.forEach(person -> System.out.println(gson.toJson(person)));

	}
}
