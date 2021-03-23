package ru.job4j.tracker;

import ru.job4j.tracker.sql.SqlTracker;

public class Runner {
    public static void main(String[] args) {
        SqlTracker sqlt = new SqlTracker();
        sqlt.init();
        sqlt.add(new Item("name_1"));
        System.out.println(sqlt.findAll());
    }
}
