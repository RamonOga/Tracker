package ru.job4j.lamda.lessons;

import java.util.List;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        for (String s : strings) {
            if (s == null) {
                return Optional.ofNullable(s);
            }
            if(s.equals(value)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}