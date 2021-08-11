package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.SingleTrackerEnum;
import ru.job4j.tracker.singleton.SingleTrackerInternal;
import ru.job4j.tracker.singleton.SingleTrackerStaticField;
import ru.job4j.tracker.singleton.SingleTrackerStaticFinalField;
import ru.job4j.tracker.store.MemTracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SingleTrackTest {

    @Test
    public void singleInternalThenEqual() {
        MemTracker memTracker1 = SingleTrackerInternal.getInstance();
        MemTracker memTracker2 = SingleTrackerInternal.getInstance();
        assertThat(memTracker1, is(memTracker2));
    }

    @Test
    public void singleEnumThenEqual() {
        MemTracker memTracker1 = SingleTrackerEnum.INSTANCE.getTracker();
        MemTracker memTracker2 = SingleTrackerEnum.INSTANCE.getTracker();
        assertThat(memTracker1, is(memTracker2));
    }

    @Test
    public void singleStaticFieldThenEqual() {
        MemTracker memTracker1 = SingleTrackerStaticField.getInstance();
        MemTracker memTracker2 = SingleTrackerStaticField.getInstance();
        assertThat(memTracker1, is(memTracker2));
    }

    @Test
    public void singleStaticFinalFieldThenEqual() {
        MemTracker memTracker1 = SingleTrackerStaticFinalField.getInstance();
        MemTracker memTracker2 = SingleTrackerStaticFinalField.getInstance();
        assertThat(memTracker1, is(memTracker2));
    }
}
