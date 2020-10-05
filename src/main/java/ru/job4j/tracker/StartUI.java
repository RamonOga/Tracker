package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {

    public static void main(String[] args) {
        Tracker test = new Tracker();
        test.add(new Item("Java"));
        test.add(new Item("C++"));
        test.add(new Item("C#"));
        test.add(new Item("Python"));
        test.add(new Item("Java"));
        Item[] arrayItems = test.findAll();
        for (int i = 0; i < arrayItems.length; i++) {
            System.out.println(arrayItems[i].getName());
        }

        System.out.println(test.findByName("Java").length);
        System.out.println(test.findById(1));
        Item one = new Item("Kotlin");
        test.replace(one, 4);
        System.out.println(test.findById(4));
    }

}
