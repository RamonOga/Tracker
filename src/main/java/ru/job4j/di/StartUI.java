package ru.job4j.di;

import ru.job4j.tracker.io.ConsoleInput;
import ru.job4j.tracker.io.ConsoleOutput;

public class StartUI {

    private Store store;
    ConsoleInput input;

    public StartUI(Store store) {
        this.store = store;
        input = new ConsoleInput(new ConsoleOutput());
    }

    public String askSrr(String str) {
        return input.askStr(str);
    }

    public int askInt(String str) {
        return input.askInt(str);
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
