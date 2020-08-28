package com.sparta.cm.sortermethods;

public class SelectionSorter extends Sort{
    @Override
    public int[] sortArray(int[] array) {
        int min_start;
        for (int i=0; i<array.length;i++){
            min_start=i;
            for(int j = min_start; j<array.length;j++){
                if (array[j]<array[min_start]){
                    min_start=j;
                }
            }
            swap(array, i, min_start);
        }
        return array;
    }
    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
