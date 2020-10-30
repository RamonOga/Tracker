package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = temp.contains(start) ? start + "/" + el : el;
                temp.add(start);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(Comparator.reverseOrder());
    }
}


        /*for (String s : deps) {
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
        }*/

/*for (String s : deps) {
        String[] arr = s.split("/");
        String text = arr[0];
        temp.add(text);
        for (int i = 1; i < arr.length; i++) {
        text += "/" + arr[i];
        temp.add(text);
        }
        }*/
