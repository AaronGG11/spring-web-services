package com.example.test.controller;

import com.example.test.model.Person;
import com.example.test.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController
{
    @Value("${person.prefijo}")
    String prefijo;

    @Autowired
    PersonServiceImp personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable Integer id){
        return personService.getPersonById(id);
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person){
        person.setPrefijo(prefijo);
        return personService.createPerson(person);
    }

    @PutMapping("/persons")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }

    @GetMapping("/persons/edad/mas/{edad}")
    public List<Person> getAgeOlderThan(@PathVariable Integer edad){
        return personService.getAgeOlderThan(edad);
    }

    @GetMapping("/persons/edad/menos/{edad}")
    public List<Person> getAgeYoungerThan(@PathVariable Integer edad){
        return personService.getAgeOlderThan(edad);
    }

    @GetMapping("/persons/nombre/{cadena}")
    public  List<Person> getPersonBeginsWith(@PathVariable String cadena){
        return personService.getPersonBeginsWith(cadena);
    }

    @GetMapping("/persons/count")
    public Integer getCount(){
        return personService.getCount();
    }

}
