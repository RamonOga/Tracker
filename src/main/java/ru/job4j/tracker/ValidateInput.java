package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    public ValidateInput(Output out) {
        super(out);
    }

    @Override
    public String askStr(String question) {
        return super.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value = -1;
            try {
                value = super.askInt(question);
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        return value;
    }
}
