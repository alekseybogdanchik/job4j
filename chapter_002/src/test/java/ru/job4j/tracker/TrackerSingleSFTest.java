package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertSame;

public class TrackerSingleSFTest {
    @Test
    public void whenHaveTwoTrackerSingleSFIsSame() {
        TrackerSingleSF first = TrackerSingleSF.getInstance();
        TrackerSingleSF second = TrackerSingleSF.getInstance();
        assertSame(first, second);
    }
}
