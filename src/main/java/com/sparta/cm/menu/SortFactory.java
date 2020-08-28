package com.sparta.cm.menu;

import com.sparta.cm.sortermethods.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortFactory {
    private static final Logger logger = LogManager.getLogger();
    public static Sort getSort(int sortType, int[] array){
        logger.trace("Creating Sort");
        return switch (sortType){
            case 1 -> new BubbleSorter();
            case 2->new MergeSorter();
            case 3-> new BinaryTreeSorter(array);
            case 4->new IterativeMergeSorter();
            case 5->new QuickSorter();
            case 6->new InsertionSorter();
            case 7->new SelectionSorter();
            default -> null;
        };
    }
}
