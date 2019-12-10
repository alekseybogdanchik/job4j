package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertSame;

public class TrackerSingleHolderTest {
    @Test
    public void whenHaveTwoTrackerSingleHolderIsSame() {
        TrackerSingleHolder first = TrackerSingleHolder.getInstance();
        TrackerSingleHolder second = TrackerSingleHolder.getInstance();
        assertSame(first, second);
    }
}

