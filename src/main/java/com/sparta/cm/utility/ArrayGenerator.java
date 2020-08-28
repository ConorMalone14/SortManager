package com.sparta.cm.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayGenerator {
    private static final Logger logger = LogManager.getLogger();
    public static int[] generateArray(int length){
        logger.trace("Generating Array");
        int[] generatedArray = new int[length];
        for (int i = 0; i<length;i++){
            double random = Math.random()*1000;
            int toAdd = (int)random;
            generatedArray[i]=toAdd;
        }
        logger.info("Generated array of length: " + length);
        return generatedArray;
    }
    public static int[] mergeArray (int[] firstArray, int[] secondArray){
        int outputLength = firstArray.length + secondArray.length;
        int[] outputArray = new int[outputLength];
        int firstArrayPointer=0;
        int secondArrayPointer=0;
        for(int i = 0; i<outputLength; i++){
            if (firstArrayPointer==firstArray.length){
                secondArrayPointer = getNewPointer(secondArray, outputArray, secondArrayPointer, i);
            }else if(secondArrayPointer==secondArray.length){
                firstArrayPointer = getNewPointer(firstArray, outputArray, firstArrayPointer, i);
            }else if(firstArray[firstArrayPointer]>=secondArray[secondArrayPointer]){
                secondArrayPointer = getNewPointer(secondArray, outputArray, secondArrayPointer, i);
            }else if (firstArray[firstArrayPointer]<secondArray[secondArrayPointer]) {
                firstArrayPointer = getNewPointer(firstArray, outputArray, firstArrayPointer, i);
            }
        }
        return outputArray;
    }

    private static int getNewPointer(int[] secondArray, int[] outputArray, int secondArrayPointer, int i) {
        outputArray[i] = secondArray[secondArrayPointer];
        secondArrayPointer++;
        return secondArrayPointer;
    }
}
