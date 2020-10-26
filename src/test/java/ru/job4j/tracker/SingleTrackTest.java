package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.SingleTrackerEnum;
import ru.job4j.tracker.singleton.SingleTrackerInternal;
import ru.job4j.tracker.singleton.SingleTrackerStaticField;
import ru.job4j.tracker.singleton.SingleTrackerStaticFinalField;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SingleTrackTest {

    @Test
    public void singleInternalThenEqual() {
        Tracker tracker1 = SingleTrackerInternal.getInstance();
        Tracker tracker2 = SingleTrackerInternal.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void singleEnumThenEqual() {
        Tracker tracker1 = SingleTrackerEnum.INSTANCE.getTracker();
        Tracker tracker2 = SingleTrackerEnum.INSTANCE.getTracker();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void singleStaticFieldThenEqual() {
        Tracker tracker1 = SingleTrackerStaticField.getInstance();
        Tracker tracker2 = SingleTrackerStaticField.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void singleStaticFinalFieldThenEqual() {
        Tracker tracker1 = SingleTrackerStaticFinalField.getInstance();
        Tracker tracker2 = SingleTrackerStaticFinalField.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}
