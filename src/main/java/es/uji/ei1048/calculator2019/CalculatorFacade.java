package es.uji.ei1048.calculator2019;

import es.uji.ei1048.calculator2019.divisision.SimpleDivider;
import es.uji.ei1048.calculator2019.multiplication.SimpleMultiplier;

public class CalculatorFacade {

    private final SimpleMultiplier multiplier;
    private final SimpleDivider divider;

    public CalculatorFacade(SimpleMultiplier multiplier, SimpleDivider divider) {
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
