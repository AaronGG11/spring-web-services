package com.example.test.service;

import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Aaron Garcia
 * @since 2020
 *
 * This is my base project about spring introduction, it contains some topics like JPA CRUD and testing
 * @see <a href="https://www.udemy.com/course/testing-spring-boot-beginner-to-guru/</a>
 */

@Service
@Transactional
public class PersonServiceImp implements PersonService
{
    @Autowired
    private PersonRepository personRepository;

    /**
     * This method saves a person object, and it uses the personRepository save method for to do it
     *
     * @param person Object person, it contains only age, name and email, the rest is automatically capture
     * @return the same person who saved
     */
    @Override
    public Person createPerson(Person person)
    {
        return personRepository.save(person);
    }


    /**
     * This method dont update, it receives a person, and delete a person by  person's id
     * next save the person that it receives by parameter
     *
     * @param person
     * @return the same person who saved
     */
    @Override
    public Person updatePerson(Person person)
    {
        personRepository.deleteById(person.getId());
        return personRepository.save(person);
    }


    /**
     * This method obtains all the people
     *
     * @return a list of people
     */
    @Override
    public List<Person> getAllPersons()
    {
        return (List<Person>) personRepository.findAll();
    }


    /**
     * This method obtains a person by id
     * if it does not exist return Null
     *
     * @param id
     * @return the person found
     */
    @Override
    public Optional<Person> getPersonById(Integer id)
    {
        return personRepository.findById(id);
    }


    /**
     * This method removes a person by id
     *
     * @param id
     */
    @Override
    public void deletePerson(Integer id)
    {
        personRepository.deleteById(id);
    }


    /**
     * This method obtains all the people older than X age
     *
     * @param edad
     * @return a list of people
     */
    public List<Person> getAgeOlderThan(Integer edad)
    {
        return personRepository.getAgeOlderThan(edad);
    }


    /**
     *  This method obtains all the people younger than X age
     *
     * @param edad
     * @return a list of people
     */
    public List<Person> getAgeYoungerThan(Integer edad){
        return personRepository.getAgeYoungerThan(edad);
    }


    /**
     * This method obtains all the people that its name begins with a specific string
     *
     * @param cadena
     * @return a list of people
     */
    public List<Person> getPersonBeginsWith(String cadena)
    {
        return personRepository.getPersonBeginsWith(cadena);
    }


    /**
     * This method counts the total number of registered people
     *
     * @return
     */
    public Integer getCount()
    {
        return personRepository.getCount();
    }


    /**
     * This method updates the prefix by email requirement
     *
     *
     * @param id is the phone number
     * @param email
     */
    public void updateIdByEmail(String id, String email)
    {
        personRepository.updateIdByEmail(id, email);
    }


    /**
     * This method updates all the people's ages to 50 years old
     *
     * @return a confirm value equals to 1
     */
    public Integer updateAge()
    {
        personRepository.updateAge();
        return 1;
    }


    /**
     * This method removes people who its age is a pair number
     */
    public void deletePairAges()
    {
        personRepository.deletePairAges();
    }


    /**
     * This method obtains the person who its email concordance with the indicate
     *
     * @param email
     * @return
     */
    public Person getByEmail(String email)
    {
        return personRepository.getByEmail(email);
    }
}
