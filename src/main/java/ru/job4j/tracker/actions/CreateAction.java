package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new request";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Create a new request ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        out.println("Requisition with the name " + name + " has been created");
        return true;
    }
}
