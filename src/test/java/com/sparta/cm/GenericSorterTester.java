package com.sparta.cm;

import com.sparta.cm.genericsortermethods.GenericSorter;
import com.sparta.cm.genericsortermethods.GenericSorterComparable;
import com.sparta.cm.utility.Printer;
import org.junit.jupiter.api.Test;

public class GenericSorterTester {
    @Test
    public void testGenericSorter(){
        Integer[] test = {1,1,2,3,4,5,6,9,1,7,8};
        GenericSorter.sortArray(test);
        Printer.genericPrint(test);
        String[] string = {"H", "E","L","L","O"};
        GenericSorter.sortArray(string);
        Printer.genericPrint(string);
    }
    @Test
    public void testGenericSorterComparable(){
        Integer[] test = {1,1,2,3,4,5,6,9,1,7,8};
        GenericSorterComparable.sortArray(test);
        Printer.genericPrint(test);
        String[] string = {"H", "E","L","L","O"};
        GenericSorterComparable.sortArray(string);
        Printer.genericPrint(string);
    }
}
