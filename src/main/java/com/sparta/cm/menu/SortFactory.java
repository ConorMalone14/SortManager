package com.sparta.cm.menu;

import com.sparta.cm.sortermethods.BubbleSorter;
import com.sparta.cm.sortermethods.IterativeMergeSorter;
import com.sparta.cm.sortermethods.MergeSorter;
import com.sparta.cm.sortermethods.Sort;
import com.sparta.cm.sortermethods.BinaryTreeSorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortFactory {
    private static final Logger logger = LogManager.getLogger();
    public static Sort getSort(String sortType, int[] array){
        logger.trace("Creating Sort");
        return switch (sortType){
            case "BubbleSort" -> new BubbleSorter();
            case "MergeSort"->new MergeSorter();
            case "BinaryTreeSort"-> new BinaryTreeSorter(array);
            case "IterativeMergeSort"->new IterativeMergeSorter();
            default -> null;
        };
    }
}
