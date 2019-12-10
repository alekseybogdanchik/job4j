package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertSame;

public class TrackerSingleEnumTest {
    @Test
    public void whenHaveTwoTrackerSingleEnumIsSame() {
        TrackerSingleEnum first = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum second = TrackerSingleEnum.INSTANCE;
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        first.add(item1);
        second.add(item2);
/*
        Item[] items = first.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getName());
        }
*/
        assertSame(first, second);
    }

}
