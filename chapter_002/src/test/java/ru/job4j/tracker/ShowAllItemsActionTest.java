package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShowAllItemsActionTest {
    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(byteOut));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAllItemsAction act = new ShowAllItemsAction();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(act.name())
                .add("Name: " + item.getName() + ", id: " + item.getId())
                .toString();
        assertThat(new String(byteOut.toByteArray()), is(expect));
        System.setOut(stdOut);
    }
}
