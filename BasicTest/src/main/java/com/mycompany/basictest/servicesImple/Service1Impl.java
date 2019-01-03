/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basictest.servicesImple;

import com.mycompany.basictest.services.Service1;
import com.mycompany.basictest.services.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class Service1Impl implements Service1{

    @Autowired
    private Service2 service2;
    
    @Override
    public String getStringService1() {
        return this.service2.getStringService2() + "|String service 1|";
    }
    
}
