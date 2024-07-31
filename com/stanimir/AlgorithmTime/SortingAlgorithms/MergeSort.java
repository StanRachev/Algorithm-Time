package stanimir.AlgorithmTime.SortingAlgorithms;

public class MergeSort {

    public static void sort(int[] array, int start, int end) { // in1 = 0, in2 = 7

        // if there is only one element left - return
        if (end - start < 2) {
            return;
        }
        // finding the middle of the arrays
        int midPoint = (start + end) / 2;

        // dividing the array to left array
        sort(array, start, midPoint);
        // and right array
        sort(array, midPoint, end);

        // temporary array for the merging faze;
        int[] tempArray = new int[end];

        // index of the left array
        int i = start;
        // index of the right array
        int j = midPoint;
        // index of the temporary array
        int k = start;

        // comparing the right/left array values and copying them to the temp array
        while (i < midPoint && j < end) {
            if (array[i] < array[j]) {
                tempArray[k] = array[i];
                i++; //
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        // copying the rest of the values to the temp array
        while (k < tempArray.length) {
            if (i == midPoint) {
                tempArray[k] = array[j];
                j++;
            } else if (j == end) {
                tempArray[k] = array[i];
                i++;
            }
            // next index of the temp array
            k++;
        }

        // copying the temp array to the original
        for (int l = start; l < end; l++) {
            array[l] = tempArray[l];
        }
    }
}
