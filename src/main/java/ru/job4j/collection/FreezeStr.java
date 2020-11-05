package ru.job4j.collection;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        int tmp = 0;
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();

        for (char a : leftArr) {
            tmp += (int) a;
        }

        for (char b : rightArr) {
            tmp -= (int) b;
        }

        return tmp == 0;
    }
}