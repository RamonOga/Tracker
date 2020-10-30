package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentFullSort() {
        List<String> input = new ArrayList<>(List.of("K1", "K1/SK1", "K1/SK2", "K1/SK1/SSK1"
                , "K1/SK1/SSK2","K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2"));
        List<String> expect = new ArrayList<>(List.of("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2"
                , "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2"));
        Comparator<String> comp = new DepDescComp();
        input.sort(comp);
        Assert.assertEquals(expect, input );

    }

    @Test
    public void whenShitUp() {
        List<String> input = new ArrayList<>(List.of("K2/SK1", "K2"));
        List<String> expect = new ArrayList<>(List.of("K2","K2/SK1"));
        Comparator<String> comp = new DepDescComp();
        input.sort(comp);
        Assert.assertEquals(expect, input );
    }
}