package com.ks.test;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class pruebas
{
    @Test
    void testInLineMock()
    {
        Map mapMock = mock(Map.class);
        assertEquals(mapMock.size(),0);
    }

}
