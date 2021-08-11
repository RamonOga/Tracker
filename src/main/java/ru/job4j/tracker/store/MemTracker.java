package ru.job4j.tracker.store;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private List<Item> items;
    private int ids;
    private int size;

    public MemTracker() {
        init();
    }

    @Override
    public void init() {
        this.items = new ArrayList<>();
        this.ids = 1;
        this.size = items.size();

    }

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public Item findById(String key) {
        int index = indexOf(Integer.parseInt(key));
        return index != -1 ? items.get(index) : null;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        rsl.addAll(items);
        return rsl;
    }

    @Override
    public boolean replace(String id, Item item) {
        int index = indexOf(Integer.parseInt(id));
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(items.get(index).getId());
            items.set(index, item);
        }
        return rsl;
    }

    @Override
    public boolean delete(String key) {
        int index = indexOf(Integer.parseInt(key));
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            size--;
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {

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