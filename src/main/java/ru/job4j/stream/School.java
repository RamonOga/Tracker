package ru.job4j.stream;

import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;


public class School {

    public List<Student> collect(List<Student> list, Predicate<Student> pred) {
        return list.stream().
                filter(pred).
                collect(Collectors.toList());

    }
    public Map<String, Student> transformToMap(List<Student> input) {
       return input.stream()
               .distinct()
               .collect(Collectors.toMap(e -> e.getSurname(), e -> e));
    }
}
