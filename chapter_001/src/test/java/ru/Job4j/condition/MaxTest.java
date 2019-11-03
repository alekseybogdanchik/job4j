package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax4To2Then4() {
        Max max = new Max();
        int result = max.max(4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax3To3Then2() {
        Max max = new Max();
        int result = max.max(3, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax15ForThreeNum() {
        Max max = new Max();
        int result = max.max(7, 4, 15);
        assertThat(result, is(15));
    }

    @Test
    public void whenMax8ForFourNum() {
        Max max = new Max();
        int result = max.max(6, 3, 8, 5);
        assertThat(result, is(8));
    }
}
