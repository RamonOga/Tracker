package ru.job4j.tracker.io;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}