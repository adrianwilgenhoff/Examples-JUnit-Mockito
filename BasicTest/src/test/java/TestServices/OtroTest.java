/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServices;

import com.mycompany.basictest.services.Service1;
import com.mycompany.basictest.services.Service2;
import com.mycompany.basictest.servicesImple.Service1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Adrian
 */
@RunWith(MockitoJUnitRunner.class)
public class OtroTest {
    
    @InjectMocks
    private Service1Impl service1;    
    
    @Mock
    private Service2 service2;
    
     @Test
    public void probandoServicio1() {
        // Condicionamos la respuesta del Mock
        when(this.service2.getStringService2()).thenReturn("|Servicio 2|");
         
        // verificamos que el mock si responde lo que esperamos
        System.out.println(this.service1.getStringService1());
         
        // Es solo para que pase la prueba-
        Assert.assertNotNull(this.service1.getStringService1());
        Assert.assertEquals(service1.getStringService1(), "|Servicio 2||String service 1|");
    }
    
    
}
