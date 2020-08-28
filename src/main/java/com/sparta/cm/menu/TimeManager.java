package com.sparta.cm.menu;

import com.sparta.cm.genericsortermethods.GenericSorter;
import com.sparta.cm.sortermethods.Sort;
import com.sparta.cm.utility.ArrayGenerator;
import com.sparta.cm.utility.SpeedTest;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeManager {
    private static final int numberOfSorts = 7;
    private static class Algorithm implements Comparable<Algorithm>{
        private final String name;
        private final double time;
        private final double best;
        private final double worst;

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
    protected static void getRankedAlgorithms(int[] generatedArray) {
        Map<Double, Algorithm> map = new HashMap<>();
        int length = generatedArray.length;
        for (int i = 1; i <= numberOfSorts; i++) {
            double avg, best, worst;
            Double[] tests;
            tests = runTests(i, generatedArray, length);
            best = tests[0];
            worst = tests[4];
            avg = (tests[0] + tests[1] + tests[2]+tests[3]+tests[4])/5;
            String name = SortFactory.getSort(i, generatedArray).getName();
            TimeManager.Algorithm algorithm = new Algorithm(name, avg, best, worst);
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

    protected static String getSpaces(int i, String s) {
        int numOfSpaces = i-s.length();
        return new String(new char[numOfSpaces]).replace('\0', ' ');
    }

    protected static Double[] runTests(int sortNum, int[] generatedArray, int length) {
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
    protected static void getAllSortsToCompare(int[] generatedArray) {
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
    protected static double getSortedArrayTime(int choice, int[] generatedArray, boolean print){
        Sort sort = SortFactory.getSort(choice, generatedArray);
        return SpeedTest.testSorts(sort, generatedArray, print);
    }
    protected static void getComparedAlgorithms(int[] generatedArray) {
        System.out.println("Please Enter First Algorithm");
        int first = MenuManager.getValueFromCommandLine(1,7);
        System.out.println("Please Enter Second Algorithm");
        int second = MenuManager.getValueFromCommandLine(1,7);
        double time1 = TimeManager.getSortedArrayTime(first,generatedArray, true);
        double time2 = TimeManager.getSortedArrayTime(second,generatedArray, false);
        System.out.println(SortFactory.getSort(first, generatedArray).getName() + " Total time: " + time1 + " Milliseconds");
        System.out.println(SortFactory.getSort(second, generatedArray).getName() + " Total time: " + time2 + " Milliseconds");
    }
}
