package com.sparta.cm.sortermethods;

import com.sparta.cm.utility.ArrayGenerator;

import java.util.Arrays;

public class MergeSorter extends Sort {
    @Override
    public int[] sortArray(int[] array) {
        return sort(array);
    }
    private int[] sort(int[] array){
        int[] mergedArray = array;
        int start=0;
        int end = array.length;
        if(array.length>1) {
            int middle = (start + end) / 2;
            int[] arrayFirstHalf = Arrays.copyOfRange(array, start, middle);
            arrayFirstHalf = sort(arrayFirstHalf);
            int[] arraySecondHalf = Arrays.copyOfRange(array, middle, end);
            arraySecondHalf = sort(arraySecondHalf);
            mergedArray = ArrayGenerator.mergeArray(arrayFirstHalf, arraySecondHalf);

        }
        return mergedArray;
    }

    @Override
    public String getName() {
        return "MergeSort";
    }

}
