package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputI = input.askInt("Enter ID for search: ");
        Item rsl = tracker.findById(inputI);
        if (rsl != null) {
            out.println(rsl);
        } else {
            out.println("Request with " + inputI + " number not found.");
        }
        return true;
    }
}
