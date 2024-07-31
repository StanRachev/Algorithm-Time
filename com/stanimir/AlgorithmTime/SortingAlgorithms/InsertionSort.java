package stanimir.AlgorithmTime.SortingAlgorithms;

public class InsertionSort {

    public static void sort(int[] array) {

        // starting from 1 because [0] is already sorted
        for (int i = 1; i < array.length; i++) {

            // storing the element we want to sort
            int num = array[i];

            // positions we want to move and compare the element
            int index = i - 1;
            while (index >= 0 && num < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = num;
        }
    }
}
