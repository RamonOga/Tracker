package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.tracker.io.ConsoleInput;
import ru.job4j.tracker.io.ConsoleOutput;

@Component
@Scope("prototype")
public class StartUI {
    @Autowired
    private Store store;
    private ConsoleInput input;

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

    @Autowired
    public void setInput(ConsoleInput input) {
        this.input = input;
    }
}
