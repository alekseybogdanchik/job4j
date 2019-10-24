package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int result = check.max(4, 3, 1, 2);
        assertThat(result, is(4));
    }



    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int result = check.max(4, 5, 3, 2);
        assertThat(result, is(5));
    }


    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int result = check.max(5, 4, 6, 2);
        assertThat(result, is(6));
    }

    @Test
    public void whenForthMax() {
        SqMax check = new SqMax();
        int result = check.max(5, 4, 3, 7);
        assertThat(result, is(7));
    }
}