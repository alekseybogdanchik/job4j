package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        int expected = 3;
        int out = (int) a.distance(b);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 4);
        int expected = 4;
        int out = (int) a.distance3d(b);
        Assert.assertEquals(expected, out);
    }
}
