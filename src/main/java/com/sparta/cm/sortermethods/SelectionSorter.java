package com.sparta.cm.sortermethods;

import com.sparta.cm.utility.ArrayGenerator;

public class SelectionSorter extends Sort{
    @Override
    public int[] sortArray(int[] array) {
        int minStart;
        for (int i=0; i<array.length;i++){
            minStart=i;
            for(int j = minStart; j<array.length;j++){
                if (array[j]<array[minStart]){
                    minStart=j;
                }
            }
            ArrayGenerator.swap(array, i, minStart);
        }
        return array;
    }

    @Override
    public String getName() {
        return "SelectionSort";
    }
}
