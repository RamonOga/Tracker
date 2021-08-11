package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.store.Store;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID for delete: ");
        if (tracker.delete(id)) {
            out.println("Item with ID " + id + " deleted ");
        } else {
            out.println("Something went wrong..");
        }
        return true;
    }
}
