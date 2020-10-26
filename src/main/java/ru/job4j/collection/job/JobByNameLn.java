package ru.job4j.collection.job;

import java.util.Comparator;

public class JobByNameLn implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
