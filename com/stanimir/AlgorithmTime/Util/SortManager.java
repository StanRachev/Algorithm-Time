package stanimir.AlgorithmTime.Util;

import stanimir.AlgorithmTime.Interfaces.ISortAlgorithm;
import stanimir.AlgorithmTime.Interfaces.ISortAlgorithmStartEnd;
import stanimir.AlgorithmTime.SortingAlgorithms.*;

public class SortManager {

    int[] sortedArray;

    public void launch() {
        UI ui = new UI();

        int sortChoice = ui.typeOfSort();
        int arrayGeneration = ui.enterOrGenerateArray();

        int[] array;
        if (arrayGeneration == 1) {
            ui.enterValuesPrompt();
            array = ArrayCreator.createCustomArray();
        } else {
            array = ArrayCreator.createRandomArray(ui.enterSizeOfArray());
        }
        double[] sortTime = returnSortTime(sortChoice, array);
        Print.printTimes(sortChoice, sortTime);
        System.out.println();

        int choice = 0;
        while ((choice = ui.printArraysPrompt()) != 4) {
            Print.printOptions(choice, array, sortedArray);
        }
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
        int[] arrToSort = ArrayCreator.copyArray(array);

        long startTime = System.nanoTime();
        algorithm.sort(arrToSort);
        long endTime = System.nanoTime();

        if (sortedArray == null) {
            sortedArray = arrToSort;
        }

        // Convert nanoseconds to seconds
        return ((endTime - startTime) / 1e6) / 1000;
    }

    private double measureTime(ISortAlgorithmStartEnd algorithm, int[] array, int start) {
        int[] arrToSort = ArrayCreator.copyArray(array);

        long startTime = System.nanoTime();
        algorithm.sort(arrToSort, start, array.length);
        long endTime = System.nanoTime();

        if (sortedArray == null) {
            sortedArray = arrToSort;
        }

        // Convert nanoseconds to seconds
        return ((endTime - startTime) / 1e6) / 1000;
    }
}
