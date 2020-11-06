package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> st != null )
                .sorted((o1, o2) -> o2.compareTo(o1))
                .takeWhile(st -> st.getScore() > bound )
                .collect(Collectors.toList());
    }
}