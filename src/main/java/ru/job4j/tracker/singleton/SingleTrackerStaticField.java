package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public class SingleTrackerStaticField {
    private static MemTracker instance;

    private SingleTrackerStaticField() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }
}
