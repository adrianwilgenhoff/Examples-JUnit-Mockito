/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aww.BasicSpringTest.Controllers;

import com.aww.BasicSpringTest.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adrian
 */
@RestController
public class GreetingController { 

    //private final GreetingService greetingService;

    /*@Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }*/

    @Autowired
    private GreetingService greetingService;
    
    @GetMapping("/hello")
    public ResponseEntity sayHello() {
        return ResponseEntity.ok(greetingService.helloWorld());
    }
}