package com.sparta.cm.sortermethods;

import com.sparta.cm.utility.ArrayGenerator;

public class BubbleSorter extends Sort {

    public int[] sortArray(int[] array){

        //outer loop
        for(int pass = 0; pass<array.length;pass++) {
            //pass
            int swapsOnPass = 0;
            for (int position = 0; position < array.length -pass; position++) {
                if(position+1>= array.length){
                    break;
                }
                else if (array[position + 1] < array[position]) {
                    ArrayGenerator.swap(array, position, position+1);
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


    @Override
    public String getName() {
        return "BubbleSort";
    }

}
