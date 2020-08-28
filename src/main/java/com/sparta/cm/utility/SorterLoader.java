package com.sparta.cm.utility;

import com.sparta.cm.exceptions.SorterLoaderException;
import com.sparta.cm.menu.SortFactory;
import com.sparta.cm.sortermethods.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

public class SorterLoader {
    private static final Logger logger = LogManager.getLogger();
    private String name;
    private static final String src = "/src/main/java";
    {
        String classpath = Sort.class.getName();
        name = classpath.substring(0, classpath.lastIndexOf('.'));
    }
    public Sort getSort(String sortType) throws SorterLoaderException {
        logger.trace("Making: " + sortType);
        if (sortType!="BinaryTreeSorter.java") {
            try {
                String sorterName = name + "." + sortType.substring(0, sortType.lastIndexOf('.'));
                logger.trace(sorterName);
                Class selectedSorter = Class.forName(sorterName);
                return (Sort) selectedSorter.getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                logger.debug(sortType, e.getMessage());
                e.printStackTrace();
                throw new SorterLoaderException();
            }
        }
        else{
            return null;
        }

    }
}
