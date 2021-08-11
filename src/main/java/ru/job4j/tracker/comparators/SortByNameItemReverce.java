package ru.job4j.tracker.comparators;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class SortByNameItemReverce implements Comparator<Item> {
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
