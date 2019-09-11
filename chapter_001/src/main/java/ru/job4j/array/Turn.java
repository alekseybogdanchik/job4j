package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int arrayHalf;
        if (array.length %2 == 0) {
            arrayHalf = array.length/2;
        } else {
            arrayHalf = (array.length-1)/2; //либо округлить вниз, но это еще не проходили;)
        }

        for (int index = 0; index != arrayHalf; index++) {
            int temp = array[index];
            array[index] = array[array.length-(index+1)];
            array[array.length-(index+1)] = temp;

        }
        return array;
    }
}
