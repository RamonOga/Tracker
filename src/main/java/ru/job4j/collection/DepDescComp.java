package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] ar1 = o1.split("/");
        String[] ar2 = o2.split("/");
        int rsl = ar2[0].compareTo(ar1[0]);
        if (rsl == 0) {
            rsl = (o1.compareTo(o2));
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(List.of("K1", "K1/SK1", "K1/SK2", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2"));
        input.sort(new DepDescComp());
        System.out.println(input);
    }
}
