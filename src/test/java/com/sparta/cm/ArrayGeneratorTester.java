package com.sparta.cm;

import com.sparta.cm.sortermethods.BubbleSorter;
import com.sparta.cm.utility.ArrayGenerator;
import com.sparta.cm.utility.Printer;
import org.junit.jupiter.api.Test;

class ArrayGeneratorTest {

    @Test
    void generateArray() {
    }
    @Test
    public void runTest(){

    }

    @Test
    void mergeArray() {
        BubbleSorter bubbleSorter = new BubbleSorter();
        int[] first = ArrayGenerator.generateArray(50);
        int[] second = ArrayGenerator.generateArray(50);
        bubbleSorter.sortArray(first);
        bubbleSorter.sortArray(second);
        Printer.printArray(first);
        Printer.printArray(second);
        int[] output = ArrayGenerator.mergeArray(first,second);
        Printer.printArray(output);

    }

}
