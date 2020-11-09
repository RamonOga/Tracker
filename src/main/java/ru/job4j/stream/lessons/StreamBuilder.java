package ru.job4j.stream.lessons;

import java.util.stream.Stream;
import java.util.Arrays;

public class StreamBuilder {
    public static Stream<Object> createStream(Integer[] data) {
        return Stream.builder().add(data[0]).add(data[data.length - 1]).build();
    }
}
