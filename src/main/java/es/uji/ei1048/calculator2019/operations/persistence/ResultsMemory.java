package es.uji.ei1048.calculator2019.operations.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResultsMemory implements ResultsStore {

    private Map<Operands, Integer> results = new HashMap<>();

    @Override
    public void store(int op1, int op2, int result) {
        results.put(createOperands(op1, op2), result);
    }

    @Override
    public int retrieve(int op1, int op2) {
        Operands operands = createOperands(op1, op2);
        if (!results.containsKey(operands)) {
            throw new ResultNotFoundEx();
        }
        return results.get(operands);
    }

    private Operands createOperands(int op1, int op2) {
        return new Operands(op1, op2);
    }

    private static class Operands {
        private final int op1;
        private final int op2;

        private Operands(int op1, int op2) {
            this.op1 = op1;
            this.op2 = op2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Operands operands = (Operands) o;
            return op1 == operands.op1 &&
                    op2 == operands.op2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(op1, op2);
        }
    }
}
