package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class SingleTrackerStaticField {
    private static SingleTrackerStaticField instance;
    private final Tracker tracker = new Tracker();

    private SingleTrackerStaticField() {
    }

    public static SingleTrackerStaticField getInstance() {
        if (instance == null) {
            instance = new SingleTrackerStaticField();
        }
        return instance;
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
        SingleTrackerStaticField one = SingleTrackerStaticField.getInstance();
    }
}
