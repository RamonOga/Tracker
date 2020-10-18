package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int key) {
        int index = indexOf(key);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> rsl = new ArrayList<>();
        for (Item item : items) {
                rsl.add(item);
        }
        return rsl;
    }

    public boolean replace(Item item, int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(items.get(index).getId());
            items.set(index,item);
        }
        return rsl;
    }

    public boolean delete(int key) {
        int index = indexOf(key);
        boolean rsl = index != -1;
        if (rsl) {
            //System.arraycopy(items, index + 1, items, index, size - index);
            items.remove(index);
            size--;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }
}