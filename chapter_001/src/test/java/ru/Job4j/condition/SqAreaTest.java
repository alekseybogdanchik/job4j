package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int inP = 4;
        int inK = 1;
        int expected = 1;
        int out = SqArea.square(inP, inK);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenp6k2s2() {
        int inP = 6;
        int inK = 2;
        int expected = 2;
        int out = SqArea.square(inP, inK);
        Assert.assertEquals(expected, out);
    }
}
