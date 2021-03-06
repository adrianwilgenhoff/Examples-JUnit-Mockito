/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Adrian
 */
import com.mycompany.exapleecuaciontest.EcuacionPrimerGrado;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EcuacionPrimerGradoIntegrationTest {

	EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();

	@Test
	public void solucionaEcuacionConMenos() {

		Double result = ecuacion.obtenerResultado("2x - 1 = 0");

		Double valueExpected = 0.5;

		assertEquals(valueExpected, result);
	}

	@Test
	public void solucionaEcuacionConMas() {

		Double result = ecuacion.obtenerResultado("2x + 1 = 0");

		Double valueExpected = -0.5;

		assertEquals(valueExpected, result);
	}

	@Test
	public void solucionaEcuacionConParte3Mayor0() {

		Double result = ecuacion.obtenerResultado("2x + 1 = 10");

		Double valueExpected = 4.5;

		assertEquals(valueExpected, result);
	}

	@Test
	public void solucionaEcuacionConParte3Menor0() {

		Double result = ecuacion.obtenerResultado("2x + 1 = -10");

		Double valueExpected = -5.5;

		assertEquals(valueExpected, result);
	}
}