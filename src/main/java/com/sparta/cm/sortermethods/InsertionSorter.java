package com.sparta.cm.sortermethods;

public class InsertionSorter extends Sort{

    @Override
    public int[] sortArray(int[] array) {
        for (int i=1; i< array.length;i++){
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }
}
