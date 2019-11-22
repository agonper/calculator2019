package es.uji.ei1048.calculator2019.e2e;

import es.uji.ei1048.calculator2019.CalculatorFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class E2ESimpleMultiplication extends E2ETestBed {

    @Test
    public void multiply_valid() {
        // Given: dos numeros
        int n1 = 10;
        int n2 = 10;

        // When: los multiplic
        int result = calculator.multiply(n1, n2);

        // Then: espero que se multipliquen correctamente
        assertEquals(100, result);
    }

    @Test
    public void multiply_invalid() {
        // Given: dos numeros
        int n1 = 10;
        int n2 = 10;

        // When: los multiplic
        int result = calculator.multiply(n1, n2);

        // Then: espero que se multipliquen correctamente
        assertNotEquals(1, result);
    }
}