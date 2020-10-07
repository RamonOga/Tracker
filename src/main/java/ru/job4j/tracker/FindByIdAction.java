package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "Find by id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputI = input.askInt( "Enter ID for search: ");
        Item rsl = tracker.findById(inputI);
        if (rsl != null) {
            System.out.println(rsl);
        } else {
            System.out.println("Request with " + inputI + " number not found.");
        }
        return true;
    }
}
