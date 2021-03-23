package ru.job4j.collection.job;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Integer[] intArr = {11, 12, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 111};
        String[] strArr = {"one", "two", "three",
                "four", "five", "six",
                "seven", "eight", "nine", "zero"};

        arrList = IteratorTest.fillShit(intArr);
        linkList = List.of(intArr);
        hashSet = Set.of(intArr);
        treeSet = Set.of(intArr);
        Iterator<Integer> a = hashSet.iterator();
     }

     public static List<Integer> fillShit(Integer[] input) {
        List<Integer> rsl = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rsl.add(i);
        }
        return rsl;
     }
}
