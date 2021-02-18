package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

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
    public boolean execute(Input input, MemTracker memTracker) {
        String inputS = (input.askStr("Enter name for search: "));
        List<Item> arrayItems = memTracker.findByName(inputS);
        if (arrayItems.size() > 0) {
            for (Item arrayItem : arrayItems) {
                System.out.println(arrayItem);
            }
        } else {
            out.println("Request with " + inputS + " not found");
        }
        return true;
    }
}
