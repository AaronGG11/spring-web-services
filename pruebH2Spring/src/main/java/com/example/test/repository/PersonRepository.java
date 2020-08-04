package com.example.test.repository;

import com.example.test.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer>
{
    @Query(value = "SELECT * FROM Person WHERE edad > ?1", nativeQuery = true)
    public List<Person> getAgeOlderThan(Integer edad);

    @Query(value = "SELECT * FROM Person WHERE edad < ?1", nativeQuery = true)
    public List<Person> getAgeYoungerThan(Integer edad);

    @Query(value = "SELECT * FROM Person WHERE nombre like ?1%", nativeQuery = true)
    public List<Person> getPersonBeginsWith(String cadena);

    @Query(value = "SELECT COUNT(*) FROM Person", nativeQuery = true)
    public Integer getCount();
}
