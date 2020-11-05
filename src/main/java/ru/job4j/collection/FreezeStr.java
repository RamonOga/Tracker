package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();

        Arrays.sort(leftArr);
        Arrays.sort(rightArr);

        return Arrays.equals(leftArr, rightArr);
    }
}