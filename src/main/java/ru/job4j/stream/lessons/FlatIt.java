package ru.job4j.stream.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> rsl = new ArrayList<>();
        while (it.hasNext()) {
            rsl.add(it.next().next());
        }
        return new ArrayList<>();
    }
}
