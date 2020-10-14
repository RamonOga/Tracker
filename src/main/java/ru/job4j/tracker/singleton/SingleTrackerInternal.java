package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class SingleTrackerInternal {

    private final Tracker tracker = new Tracker();

    private SingleTrackerInternal() {
    }

    public static SingleTrackerInternal getInstance() {
        return Holder.INCTANCE;
    }

    private static final class Holder {
        private static final SingleTrackerInternal INCTANCE = new SingleTrackerInternal();
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
        SingleTrackerInternal one = SingleTrackerInternal.getInstance();

    }

}
