package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasonCalc {

    public static List<Double> diapason(int start, int finish, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double index = start; index != finish; index++) {
            result.add(func.apply(index));
        }
        return result;
    }
}
