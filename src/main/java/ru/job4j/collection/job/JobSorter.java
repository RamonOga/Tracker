package ru.job4j.collection.job;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {

        List<Job> jobs = Arrays.asList(
                new Job("Sigma", 1),
                new Job("Alpha", 4),
                new Job("Gamma", 2),
                new Job("Beta", 0)
        );
    }
}