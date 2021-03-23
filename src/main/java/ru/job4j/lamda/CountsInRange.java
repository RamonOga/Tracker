package ru.job4j.lamda;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.List;

public class CountsInRange {

    public List<Double> diapason(int str, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = str; i < end; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }
}
