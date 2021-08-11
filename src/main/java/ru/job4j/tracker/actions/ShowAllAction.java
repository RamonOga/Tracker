package ru.job4j.tracker.actions;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> items;
        out.println("==== Show all items ====");
        items = tracker.findAll();
        for (Item value : items) {
            out.println(value);
        }
        return true;
    }
}
