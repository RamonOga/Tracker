package ru.job4j.collection;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] tmp = line.split(" ");
        for (String word : tmp) {
            if (!origin.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
