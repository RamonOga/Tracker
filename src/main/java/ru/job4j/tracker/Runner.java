package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.HbmTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) {
        Store tracker = new HbmTracker();
        Item item1 = new Item(0, "name1", "description1");
        Item item2 = new Item(0, "name1", "description1");
        Item itemforUpdate = new Item(0, "UpdateName", "UpdateDescription");


        System.out.println(tracker.findByName("FindByNameTest"));


    }
}
