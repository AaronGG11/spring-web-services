package com.example.test.controller;

import com.example.test.model.Person;
import com.example.test.service.PersonServiceImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ks")
public class PersonController
{
    private Logger logger = LogManager.getLogger(PersonController.class.getName());

    @Value("${person.prefijo}")
    String prefijo;

    @Autowired
    PersonServiceImp personService;

    @RequestMapping(value = "/inicio")
    public String saludar()
    {
        logger.info("Saludo correcto");
        return "Hola amigos";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons()
    {

        List<Person> result = null;

        try
        {
            result = personService.getAllPersons();
            logger.info("getAllPersons() works OK");
        }
        catch (Exception e)
        {
            logger.error("getAllPersons() does not work OK");
        }

        return result;
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public Optional<Person> getPersonById(@Valid @PathVariable Integer id)
    {
        return personService.getPersonById(id);
    }

    @PostMapping("/persons")
    public Person createPerson(@Valid @RequestBody Person person){
        person.setPrefijo(prefijo);

        Person result = personService.createPerson(person);

        if (result == null)
        {
            logger.error("createPerson() does not work OK");
        }
        else
        {
            logger.info("createPerson() works OK");
        }

        return result;
    }

    @PutMapping("/persons")
    public Person updatePerson(@Valid @RequestBody Person person)
    {
        Person result = personService.updatePerson(person);

        if (result == null)
        {
            logger.error("createPerson() does not work OK");
        }
        else
        {
            logger.info("createPerson() works OK");
        }

        return result;
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@Valid @PathVariable Integer id)
    {
        try
        {
            personService.deletePerson(id);
            logger.info("deletePerson() works OK");
        }
        catch (Exception e)
        {
            logger.error("deletePerson() does not work OK");
        }
    }

    @GetMapping("/persons/edad/mas/{edad}")
    public List<Person> getAgeOlderThan(@Valid @PathVariable Integer edad){
        return personService.getAgeOlderThan(edad);
    }

    @GetMapping("/persons/edad/menos/{edad}")
    public List<Person> getAgeYoungerThan(@Valid @PathVariable Integer edad){
        return personService.getAgeOlderThan(edad);
    }

    @GetMapping("/persons/nombre/{cadena}")
    public  List<Person> getPersonBeginsWith(@Valid @PathVariable String cadena){
        return personService.getPersonBeginsWith(cadena);
    }

    @GetMapping("/persons/count")
    public Integer getCount(){
        return personService.getCount();
    }

    @PutMapping("/persons/update/prefijo/{id}/byemail/{email}")
    public void updateIdByEmail(@PathVariable("id") String id, @PathVariable("email") String email)
    {
        personService.updateIdByEmail(id, email);
    }

    @PutMapping("/persons/cambioedad")
    public Integer updateAge()
    {
        return personService.updateAge();
    }


    @DeleteMapping("/persons/pairs")
    public void deletePairAges()
    {
        personService.deletePairAges();
    }

    @RequestMapping(value = "/persons/byemail/{email}", method = RequestMethod.GET)
    public Person getByEmail( @PathVariable String email)
    {
        return personService.getByEmail(email);
    }
}
