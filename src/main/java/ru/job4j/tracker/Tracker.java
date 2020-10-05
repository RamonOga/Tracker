package ru.job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int key) {
        Item rsl = null;
        for (Item item : items) {
            if (item.getId() == key) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            } else if (item.getName().equals(key)) {
                rsl[count] = item;
                count++;
            }
        }
        rsl = Arrays.copyOf(rsl, count);
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                rsl[count] = item;
                count++;
            }
        }
        rsl = Arrays.copyOf(rsl, count);
        return rsl;
    }
}