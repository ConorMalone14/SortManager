package com.sparta.cm.sortermethods;

import com.sparta.cm.utility.ArrayGenerator;

public class QuickSorter extends Sort{
    //code adapted from geeksforgeeks
    @Override
    public int[] sortArray(int[] array) {
        sort(array, 0, array.length-1);
        return array;
    }
    private void sort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int index = partition(arr, low, high);
            sort(arr, low, index-1);
            sort(arr, index+1, high);
        }
    }
    private int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int indexOfSmallestElement = (low-1);
        for (int pointer=low; pointer<high; pointer++)
        {
            if (arr[pointer] < pivot)
            {
                indexOfSmallestElement++;
                ArrayGenerator.swap(arr, pointer, indexOfSmallestElement);
            }
        }
        ArrayGenerator.swap(arr, high, indexOfSmallestElement + 1);
        return indexOfSmallestElement+1;
    }


    @Override
    public String getName() {
        return "QuickSort";
    }
}
