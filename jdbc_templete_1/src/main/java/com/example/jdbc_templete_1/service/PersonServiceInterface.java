package com.example.jdbc_templete_1.service;

import com.example.jdbc_templete_1.model.Person;

import java.util.List;

public interface PersonServiceInterface
{
    Integer createPerson(Person person);
    List<Person> getAllPersons();
    void updatePerson(Person person);
    Person getPersonById(Integer id);
    void deletePerson(Integer id);
}
