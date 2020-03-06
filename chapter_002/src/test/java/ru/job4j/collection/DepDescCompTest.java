package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void compare2() {
        int rsl = new DepDescComp().compare(
                "K1",
                "K1/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void compare3() {
        int rsl = new DepDescComp().compare(
                "K1/SK1",
                "K1/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void compare4() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0));
    }
}