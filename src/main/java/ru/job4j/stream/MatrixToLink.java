package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MatrixToLink {
    public static void main(String[] args) {
        Integer[][] mat = { {1,2,3}, {4,5,6}, {7,8,9} };
        Arrays.stream(mat);
        List<Integer> rsl = new ArrayList<>();
        Stream.of(mat)
                .forEach(e -> rsl.addAll(Arrays.asList(e)));
    }
}
