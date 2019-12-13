package es.uji.ei1048.calculator2019.operations.divisision;

import es.uji.ei1048.calculator2019.operations.SimpleOperation;

public class SimpleDivider implements SimpleOperation {
    public int calculate(int n1, int n2) {
        if (n2 == 0) {
            throw new ZeroDivisionException();
        }
        return n1 / n2;
    }
}
