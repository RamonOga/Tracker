package ru.job4j.tracker.singleton;

import ru.job4j.tracker.store.MemTracker;

public class SingleTrackerStaticFinalField {
    private static final MemTracker INSTANCE = new MemTracker();

    private SingleTrackerStaticFinalField() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

}
