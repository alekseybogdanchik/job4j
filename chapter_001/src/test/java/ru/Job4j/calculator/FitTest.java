package ru.job4j.calculator;


import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        int in = 180;
        int expected = 92;
        int out = (int) Fit.manWeight(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void WomanWeight() {
        int in = 165;
        int expected = 63;
        int out = (int) Fit.womanWeight(in);
        Assert.assertEquals(expected, out);
    }
}