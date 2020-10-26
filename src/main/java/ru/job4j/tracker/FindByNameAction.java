package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        String inputS = (input.askStr("Enter name for search: "));
        List<Item> arrayItems = tracker.findByName(inputS);
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
