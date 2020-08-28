package com.sparta.cm.genericsortermethods;

public class GenericSorter{

    public static <T> T[] sortArray(T[] array){

        //outer loop
        for(int pass = 0; pass<array.length;pass++) {
            //pass
            int swapsOnPass = 0;
            for (int position = 0; position < array.length -pass; position++) {
                if(position+1>= array.length){
                    break;
                }
                else if (array[position+1].toString().compareTo(array[position].toString())<0){
                        swap(array, position);
                    swapsOnPass++;
                }
            }
            if (swapsOnPass==0){
                break;
                //this isn't necessary it just wastes less time on a sorted list
            }
        }
        return array;
    }

    private static <T> void swap(T[] array, int position) {
        T temp = array[position + 1];
        array[position + 1] = array[position];
        array[position] = temp;
    }

}
