package ru.job4j.stream;

import ru.job4j.tracker.model.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    private List<String> listStr = List.of("java", "js", "C++", "C#", "go", "kotlin");
    private List<Integer> listInt = IntStream.range(1, 10)
            .boxed()
            .collect(Collectors.toList());
    private List<User> listUser = List.of(new User(1, "Ramon", "1234"),
                                new User(2, "Gamon", "2341"),
                                new User(3, "Bamon", "3412"),
                                new User(4, "Vamon", "4123"));

    public List<String> listIntToString() {
        return listInt.stream()
                .map(a -> a.toString())
                .collect(Collectors.toList());
    }

    public Map<Integer, String> listToSet() {
        return listUser.stream()
                .collect(Collectors.toMap(
                        key -> key.getId(),
                        value -> value.getUsername()
                ));
    }

    public List<User> changeAllPass() {
        return listUser.stream()
                .peek(a -> a.setPassword(UUID.randomUUID()
                        .toString()))
                .collect(Collectors.toList());
    }

    public Optional<Integer> intTo() {
        return listInt.stream().reduce((a, b) -> a + b);
    }

    public void toBreak() {
        listUser.add(new User());
    }

    public static void main(String[] args) {
        List<User> listUser = List.of(new User(1, "Ramon", "1234"),
                new User(2, "Gamon", "2341"),
                new User(3, "Bamon", "3412"),
                new User(4, "Vamon", "4123"));
        List<String> list = List.of("ghyk");

        listUser.add(new User());
    }
}
