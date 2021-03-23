package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int minSize = Math.min(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
            int rsl = Character.compare(leftArr[i], rightArr[i]);
            if (rsl != 0) {
                return rsl;
            }
        }

        return Integer.compare(left.length(), right.length());
    }
}