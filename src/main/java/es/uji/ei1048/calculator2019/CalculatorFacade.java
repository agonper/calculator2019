package es.uji.ei1048.calculator2019;

import es.uji.ei1048.calculator2019.operations.SimpleOperation;

public class CalculatorFacade {

    private final SimpleOperation multiplier;
    private final SimpleOperation divider;

    public CalculatorFacade(SimpleOperation multiplier, SimpleOperation divider) {
        this.multiplier = multiplier;
        this.divider = divider;
    }

    public int multiply(int n1, int n2) {
        return multiplier.calculate(n1, n2);
    }

    public int divide(int n1, int n2) {
        return divider.calculate(n1, n2);
    }
}
