package es.uji.ei1048.calculator2019.operations;

import es.uji.ei1048.calculator2019.operations.persistence.ResultNotFoundEx;
import es.uji.ei1048.calculator2019.operations.persistence.ResultsStore;

public class MemoizedSimpleOperation implements SimpleOperation {

    private final SimpleOperation parent;
    private final ResultsStore store;

    public MemoizedSimpleOperation(SimpleOperation parent, ResultsStore store) {
        this.parent = parent;
        this.store = store;
    }


    public int calculate(int n1, int n2) {
        try {
            return store.retrieve(n1, n2);
        } catch (ResultNotFoundEx e) {
            int result = parent.calculate(n1, n2);
            store.store(n1, n2, result);
            return result;
        }
    }
}
