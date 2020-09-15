package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(action);
        new StartUI().init(input, new SqlTracker(), actions);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(byteOut));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(action);
        new StartUI().init(input, new SqlTracker(), actions);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu:")
                .add("0. Stub action")
                .toString();
        assertThat(new String(byteOut.toByteArray()), is(expect));
        System.setOut(stdOut);
    }
}
