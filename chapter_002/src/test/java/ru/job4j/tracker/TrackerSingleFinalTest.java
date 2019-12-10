package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertSame;

public class TrackerSingleFinalTest {
    @Test
    public void whenHaveTwoTrackerSingleFinalIsSame() {
        TrackerSingleFinal first = TrackerSingleFinal.getInstance();
        TrackerSingleFinal second = TrackerSingleFinal.getInstance();
        assertSame(first, second);
    }
}
