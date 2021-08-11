package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

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
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID for search: ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            out.println(rsl);
        } else {
            out.println("Request with " + id + " number not found.");
        }
        return true;
    }
}
