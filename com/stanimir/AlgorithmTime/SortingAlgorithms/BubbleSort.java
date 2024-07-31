package stanimir.AlgorithmTime.SortingAlgorithms;

public class BubbleSort {

    public static void sort(int[] array) {
        int length = array.length;

        while (length != 0) {
            for (int i = 1; i < length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            length--;
        }
    }
}
