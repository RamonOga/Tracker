package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparators.SortByIdItem;
import ru.job4j.tracker.comparators.SortByIdItemReverce;
import ru.job4j.tracker.comparators.SortByNameItem;
import ru.job4j.tracker.comparators.SortByNameItemReverce;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void sortById() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(10003, "zzzz"));
        list.add(new Item(10001, "rrrr"));
        list.add(new Item(10002, "1111"));
        list.sort(new SortByIdItem());
        int expected = 10001;
        assertThat(expected, is(list.get(0).getId()));
    }

    @Test
    public void sortByIdReverce() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(10003, "zzzz"));
        list.add(new Item(10001, "rrrr"));
        list.add(new Item(10002, "1111"));
        list.sort(new SortByIdItemReverce());
        int expected = 10003;
        assertThat(expected, is(list.get(0).getId()));
    }

    @Test
    public void sortName() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(10003, "zzzz"));
        list.add(new Item(10001, "rrrr"));
        list.add(new Item(10002, "1111"));
        list.sort(new SortByNameItem());
        String expected = "1111";
        assertThat(expected, is(list.get(0).getName()));
    }

    @Test
    public void sortByNameReverce() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(10003, "zzzz"));
        list.add(new Item(10001, "rrrr"));
        list.add(new Item(10002, "1111"));
        list.sort(new SortByNameItemReverce());
        String expected = "zzzz";
        assertThat(expected, is(list.get(0).getName()));
    }

}
