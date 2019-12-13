package es.uji.ei1048.calculator2019.operations.persistence;

public interface ResultsStore {
    void store(int op1, int op2, int result);

    int retrieve(int op1, int op2);
}
