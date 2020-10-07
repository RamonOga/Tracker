package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute (Input input, Tracker tracker) {
        Item[] arrayItems;
        out.println("=== Show all items ====");
        arrayItems = tracker.findAll();
        for (Item value : arrayItems) {
            out.println(value);
        }
        return true;
    }
}