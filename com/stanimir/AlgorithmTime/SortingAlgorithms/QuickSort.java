package stanimir.AlgorithmTime.SortingAlgorithms;

import java.util.Random;

public class QuickSort {

    public static void sort(int[] numbers, int start, int end) {

        // elements > pivot to its right else to its left;

        if (end - start < 2) { // if only one element in the array, return
            return;
        }

        int midPoint = partition(numbers, start, end);
        sort(numbers, start, midPoint);
        sort(numbers, midPoint+1, end);
    }

    public static int partition(int[] array, int start, int end) {

        Random random = new Random();
        int randomPivot = random.nextInt(end);

        int i = start;
        int j = end;
        int pivot = array[randomPivot];

        while (i < j) {
            while (pivot <= array[--j] && i < j);
            if (i < j) {
                array[i] = array[j];
            }
            while (pivot >= array[++i] && i < j);
            if (i < j) {
                array[j] = array[i];
            }
        }

        array[j] = pivot;
        return j;
    }
}
