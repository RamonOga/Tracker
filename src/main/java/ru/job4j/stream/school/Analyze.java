package ru.job4j.stream.school;

import javax.swing.*;
import java.security.KeyStore;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(a -> a.getSubjects().stream())
                .map(Subject::getScore)
                .mapToInt(a -> a.intValue())
                .average()
                .orElse(-1D);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil ->
                new Tuple(pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .map(Subject::getScore)
                                .mapToInt(a -> a.intValue())
                                .average().orElse(-1D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pup -> pup.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                      .entrySet().stream()
              .map((a) -> new Tuple(a.getKey(), a.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil ->
                new Tuple(pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .map(Subject::getScore)
                                .mapToInt(a -> a.intValue())
                                .sum()))
                .max((o1, o2) -> Double.compare(o1.getScore(), o2.getScore())).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
       return stream.flatMap(pup -> pup.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map((a) -> new Tuple(a.getKey(), a.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore)).orElse(null);
    }
}