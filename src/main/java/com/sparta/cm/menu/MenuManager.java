package com.sparta.cm.menu;

import com.sparta.cm.exceptions.SorterLoaderException;
import com.sparta.cm.sortermethods.Sort;
import com.sparta.cm.utility.ArrayGenerator;
import com.sparta.cm.utility.Printer;
import com.sparta.cm.utility.SorterLoader;
import com.sparta.cm.utility.SpeedTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
    private static final Logger logger = LogManager.getLogger();
    public static void launchMenu(){

        System.out.println("Enter Option");
        System.out.println("0. Compare All");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Binary Tree Sort");
        System.out.println("4. Merge Sort (Iterative)");


        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("Enter length of array to automatically generate:");
        int length = sc.nextInt();
        int[] generatedArray = ArrayGenerator.generateArray(length);
        System.out.println("Unsorted");
        Printer.printArray(generatedArray);
        getSortedArray(choice, generatedArray);


    }
    private static void getSortedArray(int choice, int[] generatedArray){
        final int[] unsorted = generatedArray;
        Sort bubbleSorter = SortFactory.getSort("BubbleSort", generatedArray);
        Sort mergeSorter = SortFactory.getSort("MergeSort", generatedArray);
        Sort bts = SortFactory.getSort("BinaryTreeSort", generatedArray);
        Sort ims = SortFactory.getSort("IterativeMergeSort", generatedArray);

        //Post SortLoader Methods;
        SorterLoader sorterLoader = new SorterLoader();
        Sort qs = null;
        Sort is = null;
        Sort ss = null;
        try {
            qs = sorterLoader.getSort("QuickSorter.java");
            is= sorterLoader.getSort("InsertionSorter.java");
            ss=sorterLoader.getSort("SelectionSorter.java");
        }catch(Exception e){
            logger.debug(e.getMessage());
        }
        SpeedTest speedTest = new SpeedTest();

        if (choice== 0){
            bubbleSorter.print=true;
            speedTest.testSorts(bubbleSorter, unsorted, true);
            speedTest.testSorts(mergeSorter, unsorted, false);
            speedTest.testSorts(bts, unsorted, false);
            speedTest.testSorts(ims, unsorted, false);
            speedTest.testSorts(qs, unsorted, false);
            speedTest.testSorts(is, unsorted, false);
            speedTest.testSorts(ss, unsorted, false);
        }
        if(choice==1){
            speedTest.testSorts(bubbleSorter, unsorted, true);
        }if (choice==2){
            speedTest.testSorts(mergeSorter, unsorted, true);
        }if(choice==3){
            speedTest.testSorts(bts, unsorted, true);
        }if (choice == 4){
            speedTest.testSorts(ims, unsorted, true);
        }if (choice==5){
            speedTest.testSorts(qs, unsorted, true);
        }if(choice==6){
            speedTest.testSorts(is, unsorted, true);
        }if(choice==7){
            speedTest.testSorts(ss, unsorted, true);
        }


    }
    /*
    private static void getChoice(int choice){
        ArrayList<Sort> sorts = new ArrayList<Sort>();
        if(choice==0){
        sorts.add(getSorts()
    }
    private static void getSorts(){

    }
    private static void runTests(ArrayList<Sort> sorts, int[] unsorted){

        sorts.forEach((sort) -> runTest(sort, unsorted));
    }
    private static void runTest(Sort sort, int[]unsorted){

        SpeedTest.testSorts(sort, unsorted, sort.print);
    }*/
}
