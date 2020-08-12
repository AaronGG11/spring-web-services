package com.example.test.repository;

import com.example.test.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Query(value = "SELECT * FROM Person WHERE email like ?1% ", nativeQuery = true)
    public Person getByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET prefijo = :id WHERE email = :email", nativeQuery = true)
    public void updateIdByEmail(@Param("id") String newId, @Param("email") String email);

    @Modifying
    @Query(value = "UPDATE Person SET edad = 50", nativeQuery = true)
    public Integer updateAge();

    @Modifying
    @Query(value = "DELETE FROM Person WHERE (edad % 2) = 0", nativeQuery = true)
    public void deletePairAges();
}
