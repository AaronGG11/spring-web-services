package com.example.jdbc_templete_1.service;

import com.example.jdbc_templete_1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService implements PersonServiceInterface
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer createPerson(Person person)
    {
        return jdbcTemplate.update("INSERT INTO person (nombre, edad) VALUES(?, ?)",
                new Object[]{
                        person.getNombre(), person.getEdad()
                });
        //String query = String.format("INSERT INTO person (nombre, edad) VALUES(%s, %d)", person.getNombre(), person.getEdad());
        //return jdbcTemplate.update(query);
    }

    @Override
    public List<Person> getAllPersons()
    {
        //return jdbcTemplate.queryForList("SELECT * FROM person", new Object[]{}, Person.class);
        return jdbcTemplate.query("select * from person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setNombre(rs.getString("nombre"));
                person.setEdad(rs.getInt("edad"));
                return person;
            }
        });
    }

    @Override
    public void updatePerson(Person person)
    {
    }

    @Override
    public Person getPersonById(Integer id)
    {
        return null;
    }

    @Override
    public void deletePerson(Integer id)
    {

    }
}
