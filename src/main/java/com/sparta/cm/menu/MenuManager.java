package com.sparta.cm.menu;

import com.sparta.cm.genericsortermethods.GenericSorter;
import com.sparta.cm.sortermethods.Sort;
import com.sparta.cm.utility.ArrayGenerator;
import com.sparta.cm.utility.Printer;
import com.sparta.cm.utility.SpeedTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.*;

public class MenuManager {
    private static int numberOfSorts = 7;
    private static String[] sorts = {"Compare Menu", "BubbleSort", "MergeSort", "BinaryTreeSort", "IterativeMergeSort", "QuickSort", "InsertionSort", "SelectionSort"};
    private static final Logger logger = LogManager.getLogger();
    public static void launchMenu(){
        while(true) {
            System.out.println();
            System.out.println("Enter Option");
            System.out.println("-1. Exit The Program");
            System.out.println("0. " + sorts[0]);
            showSortOptions();
            int[]choices = getChoiceInput(7);
            int choice = choices[0];
            int length = choices[1];
            int[] generatedArray = ArrayGenerator.generateArray(length);
            if(choice==0){
                compareMenu(generatedArray);
            }else {
                showUnsortedArray(generatedArray);
                double time = getSortedArrayTime(choice, generatedArray, true);
                System.out.println(SortFactory.getSort(choice,generatedArray).getName() + " Total time: " + time + " Milliseconds");

            }
        }
    }

    private static void showSortOptions() {
        for (int i = 1; i <= numberOfSorts; i++) {
            System.out.println(i + ". " + sorts[i]);
        }
    }

    public static void compareMenu(int[] generatedArray){
        showCompareOptions();
        int choice = getValueFromCommandLine(0,2);

        if (choice == 0){
            showUnsortedArray(generatedArray);
            getAllSortsToCompare(generatedArray);
        }else if (choice == 1) {
            showSortOptions();
            showUnsortedArray(generatedArray);
            getComparedAlgorithms(generatedArray);
        }else if(choice==2){
            getRankedAlgorithms(generatedArray);
        }

    }

    private static void getComparedAlgorithms(int[] generatedArray) {
        System.out.println("Please Enter First Algorithm");
        int first = getValueFromCommandLine(1,7);
        System.out.println("Please Enter Second Algorithm");
        int second = getValueFromCommandLine(1,7);
        double time1 = getSortedArrayTime(first,generatedArray, true);
        double time2 = getSortedArrayTime(second,generatedArray, false);
        System.out.println(SortFactory.getSort(first, generatedArray).getName() + " Total time: " + time1 + " Milliseconds");
        System.out.println(SortFactory.getSort(second, generatedArray).getName() + " Total time: " + time2 + " Milliseconds");
    }

    private static void showCompareOptions(){
        System.out.println("What would you like to do?");
        System.out.println("0. Compare All");
        System.out.println("1. Compare 2 Algorithms");
        System.out.println("2. Rank All Algorithms with extensive testing");
    }
    private static void showUnsortedArray(int[]generatedArray){
        System.out.println("Unsorted");
        Printer.printArray(generatedArray);
    }
    private static void getRankedAlgorithms(int[] generatedArray) {
        Map<Double, Algorithm> map = new HashMap<>();
        int length = generatedArray.length;
        for (int i = 1; i <= numberOfSorts; i++) {
            double avg, best, worst;
            Double[] tests;
            tests = runTests(i, generatedArray, length);
            best = tests[0];
            worst = tests[4];
            avg = (tests[0] + tests[1] + tests[2]+tests[3]+tests[4])/5;
            MenuManager mm = new MenuManager();
            String name = SortFactory.getSort(i, generatedArray).getName();

            MenuManager.Algorithm algorithm = mm.new Algorithm(name, avg, best, worst);
            map.put(avg, algorithm);
        }
        printResults(map);
    }

    private static void printResults(Map<Double, Algorithm> map) {
        TreeMap<Double, Algorithm> sorted = new TreeMap<>(map);
        final String milliseconds = " Milliseconds";
        System.out.println("Algorithm:"+getSpaces(30, "Algorithm:")+ "Average:"+getSpaces(40, "Average:") +"Best:"+getSpaces(40,"Best:" )+"Worst");
        for (Map.Entry<Double, Algorithm>
                entry : sorted.entrySet()){
            DecimalFormat df = new DecimalFormat("#.####");
            String avg = df.format(entry.getKey());

            System.out.println(
                    entry.getValue().getName()
                            + getSpaces(30,entry.getValue().getName())
                            + avg
                            + milliseconds
                            + getSpaces(40, avg + milliseconds)
                            + entry.getValue().getBest()
                            + milliseconds
                            + getSpaces(40, entry.getValue().getBest() + milliseconds)
                            + entry.getValue().getWorst()
                            + milliseconds
            );
        }
    }

    private static String getSpaces(int i, String s) {
        int numOfSpaces = i-s.length();
        String space = new String(new char[numOfSpaces]).replace('\0', ' ');
        return space;
    }

    private static Double[] runTests(int sortNum, int[] generatedArray, int length) {
        double test1 = getSortedArrayTime(sortNum, generatedArray, false);
        int[] generatedArray2 = ArrayGenerator.generateArray(length);
        double test2 = getSortedArrayTime(sortNum, generatedArray2, false);
        int[] generatedArray3 = ArrayGenerator.generateArray(length);
        double test3 = getSortedArrayTime(sortNum, generatedArray3, false);
        int[] generatedArray4 = ArrayGenerator.generateArray(length);
        double test4 = getSortedArrayTime(sortNum, generatedArray4, false);
        int[] generatedArray5 = ArrayGenerator.generateArray(length);
        double test5 = getSortedArrayTime(sortNum, generatedArray5, false);

        Double[] output = {test1,test2,test3, test4, test5};
        GenericSorter.sortArray(output);
        return output;
    }


    public static int[] getChoiceInput(int maxChoice) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice <= -1 || choice > maxChoice) {
            System.exit(0);
        }
        int length = -1;
        while (length<1){
            System.out.println("Enter length of array to automatically generate:");
            length= sc.nextInt();
        }
        int[] output = new int[2];
        output[0] = choice;
        output[1]=length;
        return output;
    }
    public static int getValueFromCommandLine(int lowest, int max){
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice <lowest || choice > max) {
            System.out.println("Invalid choice");
            System.exit(0);
        }

        return choice;


    }
    private static void getAllSortsToCompare(int[] generatedArray) {
        double time;
        for (int i = 1; i <= numberOfSorts; i++) {
            Sort sort = SortFactory.getSort(i, generatedArray);
            if (i == 1) {

                time = SpeedTest.testSorts(sort,generatedArray, true);
            } else {
                time = SpeedTest.testSorts(sort, generatedArray, false);
            }
            System.out.println(sort.getName() + " Total time: " + time + " Milliseconds");

        }
    }
    private static double getSortedArrayTime(int choice, int[] generatedArray, boolean print){
        Sort sort = SortFactory.getSort(choice, generatedArray);
        double time = SpeedTest.testSorts(sort, generatedArray, print);

        return time;
    }
    private class Algorithm implements Comparable<Algorithm>{
        private String name;
        private double time;
        private double best;
        private double worst;

        public Algorithm(String name, double time, double best, double worst) {
            this.name = name;
            this.time = time;
            this.best = best;
            this.worst = worst;
        }


        public String getName() {
            return name;
        }

        public double getTime() {
            return time;
        }

        public double getBest() {
            return best;
        }

        public double getWorst() {
            return worst;
        }

        @Override
        public int compareTo(Algorithm employee) {
            return (int)(this.time - employee.getTime());
        }
    }


}
