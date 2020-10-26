package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class SingleTrackerStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private SingleTrackerStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

}
