package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionTest {
    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(byteOut));
        Store tracker = new MemTracker();
        Item item = new Item("test");
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        act.execute(new StubInput(new String[] {"test"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(act.name())
                .add("Name: " + item.getName() + ", id: " + item.getId())
                .toString();
        assertThat(new String(byteOut.toByteArray()), is(expect));
        System.setOut(stdOut);
    }
}
