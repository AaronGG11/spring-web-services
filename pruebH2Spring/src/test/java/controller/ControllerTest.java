package controller;

import com.example.test.App;
import com.example.test.controller.PersonController;
import com.example.test.service.PersonServiceImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = App.class)
@ExtendWith(MockitoExtension.class)
public class ControllerTest
{

    private PersonController controller;

    @InjectMocks
    private PersonServiceImp service;


    public void setUp()
    {
        assertEquals(0, service.getCount());
    }
}
