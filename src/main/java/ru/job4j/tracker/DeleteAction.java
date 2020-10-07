package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int inputI = input.askInt("Enter ID for delete: ");
        if (tracker.delete(inputI)) {
            System.out.println("Item with ID " + inputI + " deleted ");
        } else {
            System.out.println("Something went wrong..");
        }
        return true;
    }
}
