package es.uji.ei1048.calculator2019.operations;

import es.uji.ei1048.calculator2019.operations.divisision.SimpleDivider;
import es.uji.ei1048.calculator2019.operations.persistence.ResultNotFoundEx;
import es.uji.ei1048.calculator2019.operations.persistence.ResultsMemory;
import es.uji.ei1048.calculator2019.operations.persistence.ResultsStore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MemoizedSimpleOperationTest {

    private SimpleOperation operator;
    private ResultsStore store;
    private MemoizedSimpleOperation memoized;

    @Before
    public void setUp() throws Exception {
        operator = mock(SimpleOperation.class);
        store = mock(ResultsStore.class);
        memoized = new MemoizedSimpleOperation(operator, store);
    }

    @After
    public void tearDown() throws Exception {
        operator = null;
        store = null;
        memoized = null;
    }

    @Test
    public void calculate_noConocido() {
        when(store.retrieve(anyInt(), anyInt())).thenThrow(ResultNotFoundEx.class);
        when(operator.calculate(4, 3)).thenReturn(1);

        int result = memoized.calculate(4, 3);
        verify(store, times(1)).retrieve(4, 3);
        verify(store, times(1)).store(4, 3, 1);
        assertEquals(1, result);
    }

    @Test
    public void calculate_conocido() {
        when(store.retrieve(4, 1)).thenReturn(3);

        int result = memoized.calculate(4, 1);
        verify(operator, never()).calculate(4, 1);
        assertEquals(3, result);
    }
}