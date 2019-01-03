/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aww.BasicSpringTest.ControllersTest;

import com.aww.BasicSpringTest.Controllers.GreetingController;
import com.aww.BasicSpringTest.Services.GreetingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Adrian
 */
@RunWith(MockitoJUnitRunner.class)
public class GreetingControllerTest {

    @InjectMocks
    private GreetingController controller;
    
    @Mock
    private GreetingService greetingService;
 
    // o configurar el setUp
    
    
    /*@Before
    public void setUp() {
        greetingService = Mockito.mock(GreetingService.class);
        controller = new GreetingController(greetingService);
    }*/
    
   

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() {
        Mockito.when(greetingService.helloWorld()).thenReturn("Saludos");
        ResponseEntity<String> httpResponse = controller.sayHello();

        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("Saludos", httpResponse.getBody());
    }

}
