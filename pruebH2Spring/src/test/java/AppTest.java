

import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import com.example.test.service.PersonServiceImp;
import lombok.Builder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@SpringBootTest(classes = {AppTest.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppTest
{
    @Autowired
    PersonRepository repository;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all ...");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Before each ....");

        Person person;
        person = Person.builder().edad(21).email("agarcia@kssoluciones.com").nombre("Aaron Garcia").build();
        repository.save(person);
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each ...");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all ...");
    }

    @Test
    @DisplayName("Testing duration of the findAll")
    @EnabledOnOs(OS.MAC)
    public void testJPA()
    {
        assertEquals(0,repository.getCount());
    }
}
