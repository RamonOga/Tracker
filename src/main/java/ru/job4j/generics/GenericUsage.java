package ru.job4j.generics;

import java.util.*;

public class GenericUsage {

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> input) {
        for (int i = 0; i < 10; i++) {
            input.add(i);
        }
        for(Object o : input) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Person> l = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(l);
        List<Programmer> s = List.of(new Programmer("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(s);
        List<? super Integer> arr = new ArrayList<>();
        new GenericUsage().addAll(arr);
    }

}
