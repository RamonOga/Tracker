package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class SingleTrackerStaticField {
    private static Tracker instance;

    private SingleTrackerStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
