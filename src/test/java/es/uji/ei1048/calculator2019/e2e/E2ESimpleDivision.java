package es.uji.ei1048.calculator2019.e2e;

import es.uji.ei1048.calculator2019.divisision.ZeroDivisionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class E2ESimpleDivision extends E2ETestBed {

    @Test
    public void divide_valid() {
        // Given: dos numeros
        int n1 = 10;
        int n2 = 10;

        // When: los divido
        int result = calculator.divide(n1, n2);

        // Then: espero que se dividan correctamente
        assertEquals(1, result);
    }

    @Test(expected = ZeroDivisionException.class)
    public void divide_invalid() {
        // Given: dos numeros
        int n1 = 10;
        int n2 = 0;

        // When: dividido entre 0
        int result = calculator.divide(n1, n2);

        // Then: espero que se lance una excepcion
    }
}