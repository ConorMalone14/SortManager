package com.sparta.cm.menu;

import com.sparta.cm.genericsortermethods.GenericSorter;
import com.sparta.cm.utility.ArrayGenerator;
import com.sparta.cm.utility.Printer;
import java.util.*;

public class MenuManager {
    private static final int numberOfSorts = 7;
    private static final String[] sorts = {"Additional Options", "BubbleSort", "MergeSort", "BinaryTreeSort", "IterativeMergeSort", "QuickSort", "InsertionSort", "SelectionSort"};
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
                showSecondaryMenu(generatedArray);
            }else {
                showUnsortedArray(generatedArray);
                double time = TimeManager.getSortedArrayTime(choice, generatedArray, true);
                System.out.println(SortFactory.getSort(choice,generatedArray).getName() + " Total time: " + time + " Milliseconds");

            }
        }
    }

    private static void showSortOptions() {
        for (int i = 1; i <= numberOfSorts; i++) {
            System.out.println(i + ". " + sorts[i]);
        }
    }

    public static void showSecondaryMenu(int[] generatedArray){
        showOtherOptions();
        int choice = getValueFromCommandLine(0,3);
        if (choice == 0){
            showUnsortedArray(generatedArray);
            TimeManager.getAllSortsToCompare(generatedArray);
        }else if (choice == 1) {
            showSortOptions();
            showUnsortedArray(generatedArray);
            TimeManager.getComparedAlgorithms(generatedArray);
        }else if(choice==2){
            TimeManager.getRankedAlgorithms(generatedArray);
        }else if(choice==3){
            Integer[] toSort = new Integer[generatedArray.length];
            for(int i = 0; i<generatedArray.length;i++){
                toSort[i]=generatedArray[i];
            }
            GenericSorter.sortArray(toSort);
            Printer.genericPrint(toSort);
        }

    }


    private static void showOtherOptions(){
        System.out.println("What would you like to do?");
        System.out.println("0. Compare All");
        System.out.println("1. Compare 2 Algorithms");
        System.out.println("2. Rank All Algorithms with extensive testing");
        System.out.println("3. Use a generic sort");
    }
    private static void showUnsortedArray(int[]generatedArray){
        System.out.println("Unsorted");
        Printer.printArray(generatedArray);
    }

    public static int[] getChoiceInput(int maxChoice) {

        int choice =getValueFromCommandLine(0, maxChoice);
        int length = -1;

        System.out.println("Enter length of array to automatically generate:");
        length= getValueFromCommandLine(1, Integer.MAX_VALUE);

        int[] output = new int[2];
        output[0] = choice;
        output[1]=length;
        return output;
    }
    public static int getValueFromCommandLine(int lowest, int max){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        String choiceString = sc.nextLine();
        try{
            choice = Integer.parseInt(choiceString);
        }catch(NumberFormatException e){
            System.out.println("Must be an integer");
            choice =getValueFromCommandLine(lowest, max);
        }
        if (choice==-1){
            System.exit(0);
        }
        else if (choice <lowest || choice > max) {
            System.out.println("Invalid choice");
            choice = getValueFromCommandLine(lowest,max);
        }


        return choice;


    }




}
