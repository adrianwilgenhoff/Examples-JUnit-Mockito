/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aww.BasicSpringTest.ServicesTest;

/**
 *
 * @author Adrian
 */
import com.aww.BasicSpringTest.Services.GreetingService;
import org.junit.Assert;
import org.junit.Test;

public class GreetingServiceTest {

    private GreetingService greetingService = new GreetingService();

    @Test
    public void itShouldSayHolaMundo() {
        Assert.assertEquals("Hola Mundo", greetingService.helloWorld());
    }

}