package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {
    @Test
    public void createActionTest() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "test item";

        CreateAction rep = new CreateAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(("=== Create a new request ===="
                        + ln
                        + "Requisition with the name "
                        + name
                        + " has been created"
                        + ln),
                out.toString());
        Assert.assertEquals(name, tracker.findAll().get(0).getName());
    }

    @Test
    public void deleteActionTest() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        DeleteAction rep = new DeleteAction(out);
        Item deleteItem = new Item("Delete item");
        Item saveItem = new Item("Save item");
        tracker.add(deleteItem);
        tracker.add(saveItem);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(deleteItem.getId());

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(("Item with ID " + deleteItem.getId() + " deleted "
                + ln),
                out.toString());
        Assert.assertEquals("Save item", tracker.findAll().get(0).getName());
    }

    @Test
    public void editActionTest() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(("Request with name: "
                        + replacedName
                        + " and ID: "
                        + item.getId() + " replaced"
                        + ln),
                out.toString());
        Assert.assertEquals(replacedName, tracker.findAll().get(0).getName());
    }

    @Test
    public void exitActionTest() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        ExitAction rep = new ExitAction(out);

        Input input = mock(Input.class);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(("Exiting the program"
                        + ln),
                out.toString());
    }

    @Test
    public void findByIdActionTest() {
        String name = "Test item";
        Item item = new Item(name);
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByIdAction rep = new FindByIdAction(out);
        tracker.add(item);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(item.toString() + ln,
                out.toString());
        Assert.assertEquals(name, tracker.findAll().get(0).getName());
    }

    @Test
    public void findByNameActionTest() {
        Item item = new Item("Test item");
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByNameAction rep = new FindByNameAction(out);
        tracker.add(item);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(item.toString() + ln,
                out.toString());
        Assert.assertEquals(item.getName(), tracker.findAll().get(0).getName());
    }

    @Test
    public void showAllActionTest() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        ShowAllAction rep = new ShowAllAction(out);
        Item firstItem = new Item("First item");
        Item secondItem = new Item("Second item");
        tracker.add(firstItem);
        tracker.add(secondItem);

        Input input = mock(Input.class);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();

        Assert.assertEquals(("==== Show all items ====" + ln
                        + firstItem.toString() + ln
                        + secondItem.toString() + ln
                ),
                out.toString());
        Assert.assertEquals("First item", tracker.findAll().get(0).getName());
        Assert.assertEquals("Second item", tracker.findAll().get(1).getName());
    }

}
