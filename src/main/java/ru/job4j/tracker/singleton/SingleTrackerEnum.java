package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public enum SingleTrackerEnum {
    INSTANCE;
    private static Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }

}

