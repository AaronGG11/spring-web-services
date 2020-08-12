package com.example.test.service;

import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImp implements PersonService
{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person)
    {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person)
    {
        personRepository.deleteById(person.getId());
        return personRepository.save(person);
    }
    @Override
    public List<Person> getAllPersons()
    {
        return (List<Person>) personRepository.findAll();
    }
    @Override
    public Optional<Person> getPersonById(Integer id)
    {
        return personRepository.findById(id);
    }



    @Override
    public void deletePerson(Integer id)
    {
        personRepository.deleteById(id);
    }

    public List<Person> getAgeOlderThan(Integer edad)
    {
        return personRepository.getAgeOlderThan(edad);
    }

    public List<Person> getAgeYoungerThan(Integer edad){
        return personRepository.getAgeYoungerThan(edad);
    }

    public List<Person> getPersonBeginsWith(String cadena)
    {
        return personRepository.getPersonBeginsWith(cadena);
    }

    public Integer getCount()
    {
        return personRepository.getCount();
    }

    public void updateIdByEmail(String id, String email)
    {
        personRepository.updateIdByEmail(id, email);
    }

    public Integer updateAge()
    {
        personRepository.updateAge();
        return 1;
    }

    public void deletePairAges()
    {
        personRepository.deletePairAges();
    }

    public Person getByEmail(String email)
    {
        return personRepository.getByEmail(email);
    }



}
