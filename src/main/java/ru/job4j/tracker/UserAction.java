package ru.job4j.tracker;

import ru.job4j.tracker.io.Input;

public interface UserAction {

    String name();

    boolean execute(Input input, MemTracker memTracker);
}
