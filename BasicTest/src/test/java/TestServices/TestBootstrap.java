package TestServices;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrian
 */
import com.mycompany.basictest.services.Service2;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
/*
 * Cargamos los beans desde los paquetes.
 */
@ComponentScan(basePackages = {
    "com.mm.my.first.desktop.project.with.spring.service"
}, excludeFilters = {
    @ComponentScan.Filter(Configuration.class)
})
/*
 * Marcamos el bean como un bean de configuraci&amp;oacute;n.
 */
@Configuration
/*
 * Para que los test no busquen pruebas en esta clase.
 */
@Ignore
/**
 * Clase que carga el contexto de Spring.
 */
public class TestBootstrap implements BeanDefinitionRegistryPostProcessor {
 
    private static final Logger LOGGER = Logger.getLogger(TestBootstrap.class);
 
    /**
     * Inicio del contexto de Spring para pruebas.
     */
    @PostConstruct
    public void init() {
        LOGGER.info("Inicia el contexto de Spring para pruebas.");
    }
 
    /**
     * Destrucci&amp;oacute;n del contexto de Spring para pruebas.
     */
    @PreDestroy
    public void destroy() {
        LOGGER.info("Finaliza el contexto de Spring para pruebas.");
    }
 
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry bdr)
        throws BeansException {
 
    }
 
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory clbf)
        throws BeansException {
        // Agregamos mock de Service 2.
        clbf.registerSingleton("service2",
            Mockito.mock(Service2.class));
    }
}
