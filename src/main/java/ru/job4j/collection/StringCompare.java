package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl;
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int minSize = Math.min(left.length(), right.length());
        rsl = Integer.compare(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
            int temp = Character.compare(leftArr[i], rightArr[i]);
            if (temp != 0) {
                return temp;
            }
        }
        return rsl;
    }
}