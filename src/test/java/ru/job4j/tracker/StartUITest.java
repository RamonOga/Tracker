package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubInput;
import ru.job4j.tracker.io.StubOutput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.util.ArrayList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(String.valueOf(item.getId())).getName(),
                is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(String.valueOf(item.getId())), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        String ln = System.lineSeparator();
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit." + ln
                        + "Exiting the program" + ln
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "java", "1"}
        );
        String ln = System.lineSeparator();
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Create a new request" + ln
                        + "1. Exit." + ln
                        + "=== Create a new request ====" + ln
                        + "Requisition with the name java has been created" + ln
                        + "Menu." + ln
                        + "0. Create a new request" + ln
                        + "1. Exit." + ln
                        + "Exiting the program" + ln

        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "java", "2"}
        );
        String ln = System.lineSeparator();

        MemTracker memTracker = new MemTracker();
        Item item = new Item("java");
        memTracker.add(item);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        String menu = "Menu." + ln
                + "0. Create a new request" + ln
                + "1. Find by name." + ln
                + "2. Exit." + ln;
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                 menu + item.toString()
                         + ln + menu
                         + "Exiting the program" + ln

        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "java", "1", "33", "2"}
        );
        String ln = System.lineSeparator();
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        String menu = "Menu." + ln
                + "0. Create a new request" + ln
                + "1. Find by id." + ln
                + "2. Exit." + ln;
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                menu + "=== Create a new request ====" + ln
                        + "Requisition with the name java has been created" + ln
                        + menu + "Request with 33 number not found." + ln
                        + menu + "Exiting the program" + ln
        ));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"123", "0"}
        );
        String ln = System.lineSeparator();
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit.%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit.%n"
                ) + "Exiting the program" + ln
        ));
    }
}