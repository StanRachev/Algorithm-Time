package stanimir.AlgorithmTime.Util;

import java.util.Arrays;

public class Print {

    public static void printTimes(int userChoiceSort, double... sort) {
        double[] sorts;
        sorts = sort;

        if (userChoiceSort == 1) {
            System.out.printf("%n%-20s%-15f%s", "Bubble sort:", sorts[0], "seconds.");
            System.out.printf("%n%-20s%-15f%s", "Selection sort:", sorts[1], "seconds.");
            System.out.printf("%n%-20s%-15f%s", "Insertion sort:", sorts[2], "seconds.");
            System.out.printf("%n%-20s%-15f%s", "Shell sort:", sorts[3], "seconds.");
            System.out.printf("%n%-20s%-15f%s", "Merge sort:", sorts[4], "seconds.");
            System.out.printf("%n%-20s%-15f%s%n", "Quick sort:", sorts[5], "seconds.");
        } else if (userChoiceSort == 2) {
            System.out.printf("%n%-20s%-10f%s%n", "Counting sort:", sorts[0], "seconds.");
        } else {
            System.out.printf("%n%-20s%-10f%s%n", "Radix sort:", sorts[0], "seconds.");
        }
    }

    public static void printOriginalArray(int[] array) {
        System.out.println("Original array: " + Arrays.toString(array));
    }

    public static void printSortedArray(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void printOptions(int choice, int[] arrOrig, int[] arrSorted) {
        switch (choice) {
            case 1:
                Print.printOriginalArray(arrOrig);
                System.out.println();
                break;
            case 2:
                Print.printSortedArray(arrSorted);
                System.out.println();
                break;
            case 3:
                Print.printOriginalArray(arrOrig);
                Print.printSortedArray(arrSorted);
                System.out.println();
                break;
        }
    }
}
