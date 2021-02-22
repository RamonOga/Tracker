package ru.job4j.lamda;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class CountsInRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CountsInRange function = new CountsInRange();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        CountsInRange function = new CountsInRange();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenLinearFunctionThenPowResults() {
        CountsInRange function = new CountsInRange();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(3125D, 46656D, 823543D);
        Assert.assertEquals(result, expected);
    }

}