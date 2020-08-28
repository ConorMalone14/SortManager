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
    /*public void compare(int[] array, int i){
        if(i>=1) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                compare(array, i - 1);
            }
        }
    }*/
    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    @Override
    public String getName() {
        return "InsertionSort";
    }
}
