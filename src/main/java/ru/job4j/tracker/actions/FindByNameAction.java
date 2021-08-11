package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = (input.askStr("Enter name for search: "));
        List<Item> arrayItems = tracker.findByName(name);
        if (arrayItems.size() > 0) {
            for (Item arrayItem : arrayItems) {
                out.println(arrayItem);
            }
        } else {
            out.println("Request with " + name + " not found");
        }
        return true;
    }
}
