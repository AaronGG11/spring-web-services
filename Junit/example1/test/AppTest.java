import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

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
    */

    @Disabled
    @Test
    void lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5, () -> "Sum should be greater than 5");
    }

    @Disabled
    @Test
    void assertAllExample()
    {
        App ap1 = new App("Test", "Java");

        assertAll("Test props",
                () -> assertEquals(ap1.getName(), "Test"),
                () -> assertEquals(ap1.getLanguage(), "Java")
                );
    }

    @Disabled
    @Test
    void assumtionsExample()
    {
        Assumptions.assumeTrue("abcZ".contains("Z"));
    }

    @Disabled
    @Test
    void timeOutExample()
    {
        assertTimeout(Duration.ofMillis(1000),
                () -> {Thread.sleep(500);}
        );
        System.out.println("Estuve aqui");
    }

    @Disabled
    @Test
    void timeOutPreemExample()
    {
        assertTimeoutPreemptively(Duration.ofMillis(1000),
                () -> {Thread.sleep(200);}
                );
        System.out.println("Estuve aqui 1234");
    }

    // conditional test execution
    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac()
    {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows()
    {

    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testOnLinux()
    {

    }

}