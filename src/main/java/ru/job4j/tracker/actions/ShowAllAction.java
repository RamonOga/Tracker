package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

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
    public boolean execute(Input input, MemTracker memTracker) {
        List<Item> arrayItems;
        out.println("==== Show all items ====");
        arrayItems = memTracker.findAll();
        for (Item value : arrayItems) {
            out.println(value);
        }
        return true;
    }
}
