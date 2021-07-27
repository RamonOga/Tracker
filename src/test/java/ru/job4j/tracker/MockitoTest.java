package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.EditAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;

import static org.mockito.Mockito.mock;

public class MockitoTest {
    @Test
    void createActionTest() {
        Input input = mock(Input.class);
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);
    }

    @Test
    void deleteActionTest() {

    }

    @Test
    void editActionTest() {

    }

    @Test
    void exitActionTest() {

    }

    @Test
    void findByIdActionTest() {

    }

    @Test
    void findByNameActionTest() {

    }

    @Test
    void showAllActionTest() {

    }

}
