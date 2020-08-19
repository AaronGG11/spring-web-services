package model;

import com.example.test.App;
import com.example.test.controller.PersonController;
import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ModelTest
{
    @Autowired
    PersonRepository repository;

    @Autowired
    PersonController controller;

    Person person =  Person.builder()
            .edad(22).email("agarcia@kssoluciones.com").nombre("Aaron Garcia").build();
    Person personSaved;

    @BeforeEach
    void setUpBefore()
    {
        personSaved = repository.save(person);
    }

    @AfterEach
    void verification()
    {
        System.out.println("***************************************************************");
        System.out.println("Numero de personas en BD = " + repository.getCount());
        System.out.println("***************************************************************");
    }


    @Test
    @DisplayName("Testing create")
    public void testCreate()
    {
        assertEquals(1,repository.getCount());

        assertAll("Properties test",
                () -> assertAll("String properties",
                        () -> assertEquals("Aaron Garcia", personSaved.getNombre()),
                        () -> assertEquals("agarcia@kssoluciones.com", personSaved.getEmail())),
                () -> assertAll("Integer properties",
                        () -> assertEquals(22,personSaved.getEdad()),
                        () -> assertEquals(1,personSaved.getId()))
        );

        assertEquals(personSaved,person);
    }


    @Test
    @DisplayName("Testing update")
    @Modifying
    @Transactional
    public void testUpdate()
    {
        repository.updateAge();
        assertEquals(50, repository.findById(1).get().getEdad());
    }


    @Test
    @DisplayName("Testing delete")
    @Transactional
    public void testDelete()
    {
        repository.deletePairAges();
        assertEquals(0,repository.getCount());
    }

}
