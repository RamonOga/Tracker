package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputI = input.askInt("Enter ID for delete: ");
        if (tracker.delete(inputI)) {
            out.println("Item with ID " + inputI + " deleted ");
        } else {
            out.println("Something went wrong..");
        }
        return true;
    }
}
