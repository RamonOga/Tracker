package ru.job4j.tracker.singleton;

import ru.job4j.tracker.store.MemTracker;

public class SingleTrackerInternal {

    private SingleTrackerInternal() {
    }

    public static MemTracker getInstance() {
        return Holder.INCTANCE;
    }

    private static final class Holder {
        private static final MemTracker INCTANCE = new MemTracker();
    }
}
