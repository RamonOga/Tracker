package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public enum SingleTrackerEnum {
    INSTANCE;
    private static MemTracker memTracker = new MemTracker();

    public MemTracker getTracker() {
        return memTracker;
    }

}

