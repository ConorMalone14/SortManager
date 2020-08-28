package com.sparta.cm.utility;

import com.sparta.cm.sortermethods.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SpeedTest {
    private static final Logger logger = LogManager.getLogger();
    public static void testSorts(Sorter sorter, int[] array, boolean print){
        logger.trace("Testing Speed");
        int[] output = Arrays.copyOf(array, array.length);
        Long start = System.nanoTime();
        sorter.sortArray(output);
        long end = System.nanoTime();
        if (print) {
            System.out.println("Sorted: ");
            Printer.printArray(output);
        }
        long totalTime = end-start;
        double converted = (double)totalTime;
        converted = converted/1000000;
        //long converted = TimeUnit.MILLISECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
        System.out.println(sorter.getName()+" Total time: " + converted + " Milliseconds");
        logger.info("Speed test completed in " + converted + " Milliseconds");
    }
}
