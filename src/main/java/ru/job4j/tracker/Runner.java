package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.HbmTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.io.BufferedReader;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) {

        //add();
        //replace();
        delete();
        //findAll();
        //findById();
        //findByName();

    }

    public static void add() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item(0, "name10", "desc1"));
    }

    /**
     * .IllegalStateException
     */
    public static void replace() {
        HbmTracker tracker = new HbmTracker();
        try {
            System.out.println(tracker.replace("7",
                    new Item(0, "Replaced Name1", "Replaced Desc1")));
            System.out.println(tracker.replace("66",
                    new Item(0, "Replaced Name2", "Replaced Desc2")));
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    public static void delete() {
        HbmTracker tracker = new HbmTracker();
        int id = tracker
                .add(new Item(0, "Deleted Name1", "Deleted Desc1"))
                .getId();
        tracker.delete(String.valueOf(id));
        tracker.delete("55");
    }

    public static void findAll() {
        HbmTracker tracker = new HbmTracker();
        System.out.println(tracker.findAll());
    }

    public static void findByName() {
        HbmTracker tracker = new HbmTracker();
        /*tracker.add(new Item(0, "FindByName1", "desc1"));
        tracker.add(new Item(0, "FindByName1", "desc2"));*/
        System.out.println(tracker.findByName("FindByName1"));
        System.out.println(tracker.findByName("ebobo"));
    }

    public static void findById() {
        HbmTracker tracker = new HbmTracker();
        int id = tracker
                .add(new Item(0, "FindById1", "descFID1"))
                .getId();
        System.out.println(tracker.findById(String.valueOf(id)));
        tracker.findById("123312");

    }

}
