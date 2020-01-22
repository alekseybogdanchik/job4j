package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.job4j.strategy.Paint;
import ru.job4j.strategy.Square;
import ru.job4j.strategy.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.byteOut));
    }

    @After
    public void toStandardOutput() {
        System.setOut(this.stdout);
        System.out.println("Execute after method");
    }

    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                this.byteOut.toString(),
                is(
                        new StringBuilder()
                                .append("[][][][]")
                                .append(System.lineSeparator())
                                .append("[]    []")
                                .append(System.lineSeparator())
                                .append("[]    []")
                                .append(System.lineSeparator())
                                .append("[][][][]")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.byteOut.toString(),
                is(
                        new StringBuilder()
                                .append("   +  ")
                                .append(System.lineSeparator())
                                .append("  + +  ")
                                .append(System.lineSeparator())
                                .append(" +   + ")
                                .append(System.lineSeparator())
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}