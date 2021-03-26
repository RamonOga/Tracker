package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.UserAction;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit.";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        return false;
    }
}
