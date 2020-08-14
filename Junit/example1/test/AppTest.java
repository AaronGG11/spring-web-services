import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class AppTest
{
    String name = "No se mi nombre";
    String result;

    /*
    @BeforeEach
    void setUpBefore()
    {
        name = "Aaro";
        System.out.println("Before each ... name = " + name);
    }

    @AfterEach
    void setUpAfter()
    {
        name = "Aaron";
        System.out.println("After each ... name = " + name);
    }

    @BeforeAll
    public static void setBefore()
    {
        System.out.println("Before All ...");
    }

    @AfterAll
    public static void setAfter()
    {
        System.out.println("After All ...");
    }
    */


    @Test
    @Disabled
    void saludarTest()
    {
        result = App.Saludar(name);
        assertEquals(result,"Hello " + name);
        System.out.println(result);
    }

    @Test
    @Disabled
    void despedirTest()
    {
        result = App.Despedir(name);
        assertEquals(result, "Bye " + name);
        System.out.println(result);
    }

    @Test
    void lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5, () -> "Sum should be greater than 5");
    }

    Assumptions.assum



}