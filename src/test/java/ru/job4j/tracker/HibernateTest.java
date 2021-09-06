package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.HbmTracker;

import java.util.List;

public class HibernateTest {

    private HbmTracker tracker;

    @Before
    public void setUp() {
        tracker = new HbmTracker();
    }

    @After
    public void shutdown() throws Exception {
        tracker.close();
    }

    @Test
    public void HbrAddTest() {
        Item item = new Item(0, "Name1", "Description1");
        tracker.add(item);
        Assert.assertEquals(item, tracker.findAll().get(0));
    }

    @Test
    public void HbrReplaceTest() throws Exception {
        Item item = new Item(0, "Name1", "Description1");
        tracker.add(item);
        item.setName("New_Name");
        item.setDescription("New_Description");
        tracker.replace("1", item);
        Assert.assertEquals(item, tracker.findById("1"));
    }

    @Test
    public void HbrDeleteTest() {
        Item item = new Item(0, "Name1", "Description1");
        tracker.add(item);
        tracker.delete("1");
        Assert.assertEquals(0, tracker.findAll().size());
    }

    @Test
    public void HbrFindByNameTest() {
        Item item1 = new Item(0, "Name1", "Description1");
        Item item2 = new Item(0, "Name2", "Description2");
        Item item3 = new Item(0, "Name2", "Description3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Assert.assertEquals(3, tracker.findAll().size());
        Assert.assertEquals(item2, tracker.findByName("Name2").get(0));
        Assert.assertEquals(item3, tracker.findByName("Name2").get(1));
    }

    @Test
    public void HbrFindByIdTest() {
        Item item1 = new Item(0, "Name1", "Description1");
        Item item2 = new Item(0, "Name2", "Description2");
        tracker.add(item1);
        tracker.add(item2);
        Assert.assertEquals(item1, tracker.findById("1"));
        Assert.assertEquals(item2, tracker.findById("2"));
    }

    @Test
    public void HbrFindAllTest() {
        Item item1 = new Item(0, "Name1", "Description1");
        Item item2 = new Item(0, "Name2", "Description2");
        tracker.add(item1);
        tracker.add(item2);
        Assert.assertEquals(2, tracker.findAll().size());
    }
}
