package stanimir.AlgorithmTime.SortingAlgorithms;

public class SelectionSort {

    public static void sort(int[] array) {

        int length = array.length;

        // while all elements are unsorted
        while (length != 0) {
            int biggestNum = 0;
            for (int i = 1; i < length; i++) {

                // finding the index with the biggest value
                if (array[biggestNum] < array[i]) {
                    biggestNum = i;
                }
            }
            // storing the last unsorted value and swapping it with the biggest unsorted value
            int lastIndex = array[length-1];
            array[length-1] = array[biggestNum];
            array[biggestNum] = lastIndex;

            // decrementing until there are no more values to be sorted
            length--;
        }
    }
}
