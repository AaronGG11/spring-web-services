package com.example.jdbc_templete_1.api;

import com.example.jdbc_templete_1.model.Person;
import com.example.jdbc_templete_1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonApi
{
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Integer createPerson(@RequestBody Person person)
    {
        return personService.createPerson(person);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getAllPersons()
    {
        return personService.getAllPersons();
    }

}
