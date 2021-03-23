package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MatrixToLinkTest {
    @Test
    public void matrixToLinkTest0() {
        MatrixToLink mat = new MatrixToLink();
        Integer[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> rsl = mat.arrToList(input);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertEquals(expect, rsl);

    }

    @Test
    public void matrixToLinkTest1() {
        MatrixToLink mat = new MatrixToLink();
        Integer[][] input = {{1}, {}, {}};
        List<Integer> rsl = mat.arrToList(input);
        List<Integer> expect = Arrays.asList(1);
        Assert.assertEquals(expect, rsl);

    }

    @Test
    public void matrixToLinkWhenNull() {
        MatrixToLink mat = new MatrixToLink();
        List<Integer> rsl = mat.arrToList(null);
        Assert.assertEquals(null, rsl);
    }
}