package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.store.Store;

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
    public boolean execute(Input input, Store tracker) {
        out.println("Exiting the program");
        return false;
    }
}
