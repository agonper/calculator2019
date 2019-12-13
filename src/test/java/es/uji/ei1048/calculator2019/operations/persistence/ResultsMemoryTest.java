package es.uji.ei1048.calculator2019.operations.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultsMemoryTest {

    private ResultsMemory store;

    @Before
    public void setUp() throws Exception {
        store = new ResultsMemory();
        store.store(1, 2, 3);
    }

    @After
    public void tearDown() throws Exception {
        store = null;
    }

    @Test
    public void store() {
        store.store(1, 1, 2);
    }

    @Test
    public void retrieve_existente() {
        int result = store.retrieve(1, 2);
        assertEquals(3, result);
    }

    @Test(expected = ResultNotFoundEx.class)
    public void retrieve_inexistente() {
        int result = store.retrieve(2, 2);
    }
}