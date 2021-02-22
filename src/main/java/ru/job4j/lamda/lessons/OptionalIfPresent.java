package ru.job4j.lamda.lessons;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        max(data).ifPresent(a -> System.out.println("Max: " + a));
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length > 0) {
            int max = data[0];
            for (int i : data) {
                if (i > max) {
                    max = i;
                }
            }
            return Optional.of(max);
        }
       return Optional.empty();
    }
}
