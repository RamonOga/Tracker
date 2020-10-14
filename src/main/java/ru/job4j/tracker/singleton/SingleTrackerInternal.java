package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class SingleTrackerInternal {

    private SingleTrackerInternal() {
    }

    public static Tracker getInstance() {
        return Holder.INCTANCE;
    }

    private static final class Holder {
        private static final Tracker INCTANCE = new Tracker();
    }
}
