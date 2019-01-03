/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.ServiceImpleTest;

import com.mycompany.basictestcalculator.serviceImple.CalculatorServiceImpl;
import com.mycompany.basictestcalculator.services.DataService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Adrian
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
    @InjectMocks
    private CalculatorServiceImpl calculatorService;
 
    @Mock
    private DataService dataService;
 
    @Test
    public void testCalculateAvg_simpleInput() {
        when(dataService.getListOfNumbers()).thenReturn(new int[] { 1, 2, 3, 4, 5 });
        assertEquals(3.0, calculatorService.calculateAverage(), .01);
    }
 
    @Test
    public void testCalculateAvg_emptyInput() {
        when(dataService.getListOfNumbers()).thenReturn(new int[] {});
        assertEquals(0.0, calculatorService.calculateAverage(), .01);
    }
 
    @Test
    public void testCalculateAvg_singleInput() {
        when(dataService.getListOfNumbers()).thenReturn(new int[] { 1 });
        assertEquals(1.0, calculatorService.calculateAverage(), .01);
    }
}
