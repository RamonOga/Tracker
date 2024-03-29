package ru.job4j.tracker.comparators;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class SortByIdItemReverce implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}