package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl;
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int minSize = Math.min(left.length(), right.length());
        if (left.length() > right.length()) {
            rsl = 1;
        } else if (left.length() < right.length()) {
            rsl = -1;
        } else {
            rsl = 0;
        }
        for (int i = 0; i < minSize; i++) {
            if (leftArr[i] > rightArr[i]) {
                rsl = 1;
                break;
            } else if (leftArr[i] < rightArr[i]) {
                rsl = -1;
                break;
            }
        }
        return rsl;
    }
}