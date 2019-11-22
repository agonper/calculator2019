package es.uji.ei1048.calculator2019.e2e;

import es.uji.ei1048.calculator2019.CalculatorFacade;
import es.uji.ei1048.calculator2019.divisision.SimpleDivider;
import es.uji.ei1048.calculator2019.multiplication.SimpleMultiplier;
import org.junit.After;
import org.junit.Before;

public abstract class E2ETestBed {
    protected CalculatorFacade calculator;

    @Before
    public void setUp() throws Exception {
        SimpleMultiplier multiplier = new SimpleMultiplier();
        SimpleDivider divider = new SimpleDivider();
        calculator = new CalculatorFacade(multiplier, divider);
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }
}
