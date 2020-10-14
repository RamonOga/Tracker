package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;


public class SingleTrackerStaticFinalField {
    private static final SingleTrackerStaticFinalField INSTANCE = new SingleTrackerStaticFinalField();
    private static final Tracker tracker = new Tracker();

    private SingleTrackerStaticFinalField() {
    }

    public static SingleTrackerStaticFinalField getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return tracker.add(model);
    }

    public Item findById(int key) {
        return tracker.findById(key);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(Item item, int id) {
        return tracker.replace(item, id);
    }

    public boolean delete(int key) {
        return tracker.delete(key);
    }

    public static void main(String[] args) {
        SingleTrackerStaticFinalField one = SingleTrackerStaticFinalField.getInstance();
    }
}
