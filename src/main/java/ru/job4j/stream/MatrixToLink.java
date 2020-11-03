package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MatrixToLink {
    public List<Integer> arrToList(Integer[][] input) {
        if (input != null) {
            List<Integer> rsl = new ArrayList<>();
            Stream.of(input)
                    .forEach(e -> rsl.addAll(Arrays.asList(e))
                    );
            return rsl;
        }
        return null;
    }
}
