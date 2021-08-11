package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item.";
    }

    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter Name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Request with name: " + name + " and ID: " + id + " replaced");
        } else {
            out.println("Something went wrong..");
        }
        return true;
    }
}
