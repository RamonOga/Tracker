package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item.";
    }

    public boolean execute(Input input, Tracker tracker) {
        int inputI = input.askInt("Enter ID: ");
        String inputS = input.askStr("Enter Name: ");
        Item item = new Item(inputS);
        if (tracker.replace(item, inputI)) {
            out.println("Request with name: " + inputS + " and ID: " + inputI + " replaced");
        } else {
            out.println("Something went wrong..");
        }
        return true;
    }
}
