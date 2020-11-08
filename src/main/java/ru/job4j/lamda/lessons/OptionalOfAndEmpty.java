package ru.job4j.lamda.lessons;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue1(List<String> strings, String value) {
       return strings.stream()
               .filter(a -> a.equals(value))
               .findFirst();
    }
    public static Optional<String> findValue2(List<String> strings, String value) {
        if(strings.contains(value)) {
            for(String s : strings) {
                if (s.equals(value)) {
                    return Optional.of(s);
                }
            }
        }
        return Optional.empty();
    }
}