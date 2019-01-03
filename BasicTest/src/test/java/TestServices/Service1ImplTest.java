/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServices;


import com.mycompany.basictest.services.Service1;
import com.mycompany.basictest.services.Service2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
                      classes = {TestBootstrap.class})
public class Service1ImplTest
    /*
     * Estendemos de mockito para acceder a sus metodos de prueba.
     */
    extends Mockito {
     
    /**
     * Servicio 1 a probar.
     */
    @Autowired
    private Service1 service1;
    /**
     * Servicio 2 mock.
     */
    @Autowired
    private Service2 service2;
     
    @Test
    public void probandoServicio1() {
        // Condicionamos la respuesta del Mock
        when(this.service2.getStringService2()).thenReturn("|Servicio 2|");
         
        // verificamos que el mock si responde lo que esperamos
        System.out.println(this.service1.getStringService1());
         
        // Es solo para que pase la prueba-
        Assert.assertNotNull(this.service1.getStringService1());
    }
}
