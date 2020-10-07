package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction();
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
    Item item = new Item("Old Item");
    Tracker tracker = new Tracker();
    tracker.add(item);
    String[] answers = {String.valueOf(item.getId()), "New Item" };
    UserAction action = new EditAction();
    action.execute(new StubInput(answers), tracker);
    Item replaced = tracker.findById(item.getId());
    assertThat(replaced.getName(), is("New Item"));
    }

    @Test
    public void whenDeleteItem() {
        Item item = new Item("Will delete");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        UserAction action = new DeleteAction();
        action.execute(new StubInput(answers), tracker);
        Item[] deleted = tracker.findAll();
        assertThat(deleted.length, is(0));
    }
}