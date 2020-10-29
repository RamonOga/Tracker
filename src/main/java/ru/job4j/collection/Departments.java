package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> temp = new LinkedHashSet<>();
        for (String s : deps) {
            // temp.add(s.split("/"));
            String[] arr = s.split("/");
            if (arr.length == 1) {
                temp.add(arr[0]);
            }
            if (arr.length == 2) {
                temp.add(arr[0]);
                temp.add(arr[0] + "/" + arr[1]);
            }
            if (arr.length == 3) {
                temp.add(arr[0] + "/" + arr[1]);
                temp.add(arr[0] + "/" + arr[1] + "/" + arr[2]);
            }

        }
        return rsl = List.copyOf(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(Comparator.reverseOrder());
    }
}
