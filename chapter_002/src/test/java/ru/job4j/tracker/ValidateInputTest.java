package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(byteOut));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.askInt("Enter", 1);
        assertThat(byteOut.toString(),
                is(String.format("Please enter validate data again %n"))
        );
        System.setOut(stdOut);
    }
}
