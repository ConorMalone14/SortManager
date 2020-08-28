package com.sparta.cm.utility;

public class Printer {

    public static void printArray(int[] array){

        for(int position = 0; position< array.length; position++) {
            if(position== array.length-1){
                System.out.println(array[position]);
            }else {
                System.out.print(array[position] + ", ");
            }
        }
        System.out.println("");

    }
    public static <T> void genericPrint(T[] array){
        int count = 0;
        for (T s:array){
            if(++count== array.length){
                System.out.println(s);
            }else {
                System.out.print(s + ", ");
            }

        }
    }
}
