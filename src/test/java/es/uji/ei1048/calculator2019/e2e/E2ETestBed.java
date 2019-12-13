package es.uji.ei1048.calculator2019.e2e;

import es.uji.ei1048.calculator2019.CalculatorFacade;
import es.uji.ei1048.calculator2019.operations.MemoizedSimpleOperation;
import es.uji.ei1048.calculator2019.operations.divisision.SimpleDivider;
import es.uji.ei1048.calculator2019.operations.multiplication.SimpleMultiplier;
import es.uji.ei1048.calculator2019.operations.persistence.ResultsMemory;
import es.uji.ei1048.calculator2019.operations.persistence.ResultsStore;
import org.junit.After;
import org.junit.Before;

public abstract class E2ETestBed {
    protected CalculatorFacade calculator;

    @Before
    public void setUp() throws Exception {
        MemoizedSimpleOperation memoizedMulti = createMemoizedMulti();
        MemoizedSimpleOperation memoizedDivider = createMemoizedDivider();
        calculator = new CalculatorFacade(memoizedMulti, memoizedDivider);
    }

    private MemoizedSimpleOperation createMemoizedMulti() {
        SimpleMultiplier multiplier = new SimpleMultiplier();
        ResultsStore multiResults = new ResultsMemory();
        return new MemoizedSimpleOperation(multiplier, multiResults);
    }

    private MemoizedSimpleOperation createMemoizedDivider() {
        SimpleDivider divider = new SimpleDivider();
        ResultsStore diviResults = new ResultsMemory();
        return new MemoizedSimpleOperation(divider, diviResults);
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }
}
