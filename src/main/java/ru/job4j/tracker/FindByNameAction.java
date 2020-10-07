package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "Find by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String inputS = (input.askStr("Enter name for search: "));
        Item[] arrayItems = tracker.findByName(inputS);
        if (arrayItems.length > 0) {
            for (Item arrayItem : arrayItems) {
                System.out.println(arrayItem);
            }
        } else {
            System.out.println("Request with " + inputS + " not found");
        }
        return true;
    }
}
