package com.example.test.service;
import java.util.List;
import java.util.Optional;

import com.example.test.model.Person;

public interface PersonService
{
    Person createPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Integer id);
    void deletePerson(Integer id);
}
