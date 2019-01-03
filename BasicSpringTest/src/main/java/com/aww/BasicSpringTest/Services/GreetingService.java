/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aww.BasicSpringTest.Services;

/**
 *
 * @author Adrian
 */
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String helloWorld() {
        return"Hola Mundo";
    }

}