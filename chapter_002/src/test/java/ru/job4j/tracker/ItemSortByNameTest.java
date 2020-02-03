package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemSortByNameTest {
    @Test
    public void itemSort() {
        Item first = new Item("Fix bugs");
        Item second = new Item("Load updates");
        Item third = new Item("Reboot server");

        List<Item> items = Arrays.asList(
                third,
                first,
                second
        );
        Collections.sort(items, new ItemSortByName());
        assertThat(items, is(Arrays.asList(
                first,
                second,
                third
                )
        ));
    }

    @Test
    public void itemSortRevers() {
        Item first = new Item("Fix bugs");
        Item second = new Item("Load updates");
        Item third = new Item("Reboot server");

        List<Item> items = Arrays.asList(
                first,
                third,
                second
        );
        Collections.sort(items, new ItemSortByName().reversed());
        assertThat(items, is(Arrays.asList(
                third,
                second,
                first
                )
        ));
    }
}
