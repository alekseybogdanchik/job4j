package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {

        int arrayHalf = array.length / 2;


        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - (index + 1)];
            array[array.length - (index + 1)] = temp;

        }
        return array;
    }
}
