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
    public void SingleInternalThenEqual() {
        SingleTrackerInternal tracker1 = SingleTrackerInternal.getInstance();
        SingleTrackerInternal tracker2 = SingleTrackerInternal.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void SingleEnumThenEqual() {
        SingleTrackerEnum tracker1 = SingleTrackerEnum.INSTANCE;
        SingleTrackerEnum tracker2 = SingleTrackerEnum.INSTANCE;
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void SingleStaticFieldThenEqual() {
        SingleTrackerStaticField tracker1 = SingleTrackerStaticField.getInstance();
        SingleTrackerStaticField tracker2 = SingleTrackerStaticField.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void SingleStaticFinalFieldThenEqual() {
        SingleTrackerStaticFinalField tracker1 = SingleTrackerStaticFinalField.getInstance();
        SingleTrackerStaticFinalField tracker2 = SingleTrackerStaticFinalField.getInstance();
        assertThat(tracker1, is(tracker2));
    }


}
