package ru.job4j.lamda.lessons;

import java.util.Optional;


public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> hlp = indexOf(data, el);

        if(hlp.isPresent()) {
            return hlp.get();
        };
        return -1;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        for (int i = 0; i < data.length; i++) {
            if(data[i] == el) {
                return Optional.of(i);
            }
        }
       return Optional.empty();
    }
}