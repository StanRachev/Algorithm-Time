package stanimir.AlgorithmTime.SortingAlgorithms;

public class RadixSort {

    public static void sort(int[] array) {

        // using Bubble stanimir.AlgorithmTime.Sort

        int num = 0;
        int divisor = 1;

        for (int i = array[0]; i > 0; i/=10) {
            if (num++ > 0) {
                divisor *= 10;
            }
            boolean isSorted = false;
            while (!isSorted) {
                isSorted = true;
                for (int j = 1; j < array.length; j++) {
                    if ((array[j] / divisor) % 10 < (array[j - 1] / divisor) % 10) {
                        int tempEl = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tempEl;
                        isSorted = false;
                    }
                }
            }
        }
    }
}
