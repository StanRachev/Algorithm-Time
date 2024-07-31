package stanimir.AlgorithmTime;

import stanimir.AlgorithmTime.Interfaces.ISortAlgorithm;
import stanimir.AlgorithmTime.Interfaces.ISortAlgorithmStartEnd;
import stanimir.AlgorithmTime.SortingAlgorithms.*;

import java.util.Random;
import java.util.Scanner;

public class SortManager {

    public void launch() {
        UI ui = new UI();

        int sortChoice = ui.typeOfSort();
        int sizeOfArray = ui.enterSizeOfArray();
        int arrayGeneration = ui.enterOrGenerateArray();

        int[] array;
        if (arrayGeneration == 1) {
            ui.createCustomArray();
            array = SortManager.createCustomArray(sizeOfArray);
        } else {
            array = SortManager.createRandomArray(sizeOfArray);
        }
        double[] sortTime = returnSortTime(sortChoice, array);

        printTimes(sortChoice, sortTime);
    }

    private static int[] createCustomArray(int size) {
        Scanner scan = new Scanner(System.in);

        String userInput = scan.nextLine();

        Scanner scanner = new Scanner(userInput);
        String[] userInputParameters = new String[size];
        int[] userInputParametersInt = new int[size];

        for (int i = 0; i < size; i++) {
            userInputParameters[i] = scanner.useDelimiter(",").next().replaceAll("\\s", "");
            userInputParametersInt[i] = Integer.parseInt(userInputParameters[i]);
        }

        return userInputParametersInt;
    }

    private static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(0, 100_000);
        }

        return array;
    }

    public double[] returnSortTime(int userChoiceSort, int[] array) {

        if (userChoiceSort == 1) {
            double elapsedBubble = measureTime(BubbleSort::sort, array);
            double elapsedSelection = measureTime(SelectionSort::sort, array);
            double elapsedInsertion = measureTime(InsertionSort::sort, array);
            double elapsedShell = measureTime(ShellSort::sort, array);
            double elapsedQuick = measureTime(QuickSort::sort, array, 0);
            double elapsedMerge = measureTime(MergeSort::sort, array, 0);

            return new double[]{
                    elapsedBubble, elapsedSelection, elapsedInsertion,
                    elapsedShell , elapsedMerge, elapsedQuick
            };
        } else if (userChoiceSort == 2) {
            double elapsedCounting = measureTime(CountingSort::sort, array);

            return new double[]{elapsedCounting};
        } else {
            double elapsedRadix = measureTime(RadixSort::sort, array);

            return new double[]{elapsedRadix};
        }
    }

    private double measureTime(ISortAlgorithm algorithm, int[] array) {
        int[] arrToSort = copyArray(array);

        long startTime = System.nanoTime();
        algorithm.sort(arrToSort);
        long endTime = System.nanoTime();

        // Convert nanoseconds to seconds
        return ((endTime - startTime) / 1e6) / 1000;
    }

    private double measureTime(ISortAlgorithmStartEnd algorithm, int[] array, int start) {
        int[] arrToSort = copyArray(array);

        long startTime = System.nanoTime();
        algorithm.sort(arrToSort, start, array.length);
        long endTime = System.nanoTime();

        // Convert nanoseconds to seconds
        return ((endTime - startTime) / 1e6) / 1000;
    }

    private int[] copyArray(int[] array) {
        int[] arrToSort = new int[array.length];
        System.arraycopy(array, 0, arrToSort, 0, array.length);

        return arrToSort;
    }

    private static void printTimes(int userChoiceSort, double... sort) {

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
}
