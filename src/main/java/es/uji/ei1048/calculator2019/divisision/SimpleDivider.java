package es.uji.ei1048.calculator2019.divisision;

public class SimpleDivider {
    public int calculate(int n1, int n2) {
        if (n2 == 0) {
            throw new ZeroDivisionException();
        }
        return n1 / n2;
    }
}
