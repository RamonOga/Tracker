package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToLink {
    public List<Integer> arrToList(Integer[][] input) {
        if (input != null) {
            List<Integer> rsl;
            rsl = Stream.of(input)
                    .flatMap(a -> Arrays.stream(a))
                    .collect(Collectors.toList());
            return rsl;
        }
        return null;
    }
}
