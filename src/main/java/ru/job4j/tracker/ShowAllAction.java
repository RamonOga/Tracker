package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute (Input input, Tracker tracker) {
        Item[] arrayItems;
        System.out.println("=== Show all items ====");
        arrayItems = tracker.findAll();
        for (Item value : arrayItems) {
            System.out.println(value);
        }
        return true;
    }
}
