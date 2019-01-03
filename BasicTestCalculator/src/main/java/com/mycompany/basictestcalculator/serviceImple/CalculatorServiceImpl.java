/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basictestcalculator.serviceImple;

import com.mycompany.basictestcalculator.services.CalculatorService;
import com.mycompany.basictestcalculator.services.DataService;

/**
 *
 * @author Adrian
 */
public class CalculatorServiceImpl implements CalculatorService {
    private DataService dataService;
 
    @Override
    public double calculateAverage() {
        int[] numbers = dataService.getListOfNumbers();
        double avg = 0;
        for (int i : numbers) {
            avg += i;
        }
        return (numbers.length > 0) ? avg / numbers.length : 0;
    }
 
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}