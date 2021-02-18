package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id.";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int inputI = input.askInt("Enter ID for search: ");
        Item rsl = memTracker.findById(inputI);
        if (rsl != null) {
            out.println(rsl);
        } else {
            out.println("Request with " + inputI + " number not found.");
        }
        return true;
    }
}
