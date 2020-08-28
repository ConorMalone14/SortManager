package com.sparta.cm;

import com.sparta.cm.utility.Printer;
import org.junit.jupiter.api.Test;

public class PrinterTester {


    @Test
    public void genericPrintTest(){
        Integer[] test = {1,1,2,3,4,5,6,9,1,7,8};
        Printer.genericPrint(test);
        String[] string = {"H", "E","L","L","O"};
        Printer.genericPrint(string);
    }
}
