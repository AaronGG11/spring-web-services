import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class AppTest
{
    @Test
    void test()
    {
        Car c1 = new Car();
        c1.setModel("BMW");
        c1.setPrice(320000);
        assertThat(c1.getModel(), is("BMW"));

    }
}
