package ru.job4j.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>
                (List.of(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5, -6, 6))
                .stream().filter(x -> x > 0)
                .collect(Collectors.toList());

    }

    public static List<Integer> positiveFilter(List<Integer> input) {
        return input.stream()
                    .filter(x -> x > 0)
                    .collect(Collectors.toList());
    }
}