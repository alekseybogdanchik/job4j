package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class DiapasonCalcTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenParabolicResults() {
        List<Double> result = DiapasonCalc.diapason(5, 8, x -> Math.pow(x, 2) + 4 * x + 3);
        List<Double> expected = Arrays.asList(48D, 63D, 80D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        List<Double> result = DiapasonCalc.diapason(1, 4, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0.00D, 0.69D, 1.10D);
        for (int i = 0; i < 3; i++) {
            assertEquals(expected.get(i), result.get(i), 0.01D);
        }
    }
}