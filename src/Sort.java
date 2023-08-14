import java.util.Random;

public class Sort {

    int[] array;
    int start;
    int end;

    public Sort(int size, int[] array) {
        this.array = new int[size];
        this.array = array;
        start = 0;
        end = array.length;
    }

    public void radixSort() {

        // using Bubble Sort

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

    public void countingSort() {

        int biggestNumber = array[0];

        for (int i = 1; i < array.length; i++) {
            if (biggestNumber < array[i]) {
                biggestNumber = array[i];
            }
        }

        int[] sortArray = new int[biggestNumber];

        for (int i = 0; i < array.length; i++) {
            sortArray[array[i] - 1]++;
        }

        int y = 0;

        for (int i = 0; i < sortArray.length; i++) { // i = 0
            if (sortArray[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < sortArray[i]; j++) {
                    array[y] = i + 1;
                    if (j < sortArray[i] - 1) {
                        y++;
                    }
                }
                y++;
            }
        }
    }

    public void quickSort(int[] numbers, int start, int end) {

        // elements > pivot to its right else to its left;

        if (end - start < 2) { // if only one element in the array, return
            return;
        }

        int midPoint = partition(array, start, end);
        quickSort(numbers, start, midPoint);
        quickSort(numbers, midPoint+1, end);
    }

    public static int partition(int[] array, int start, int end) {

        Random random = new Random();
        int randomPivot = random.nextInt(end);

        int i = start;
        int j = end;
        int pivot = array[randomPivot]; // pivot is always the first element in the array

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

    public void mergeSort(int[] array, int start, int end) { // in1 = 0, in2 = 7

        if (end - start < 2) { // if there is only one element left - return
            return;
        }

        int midPoint = (start + end) / 2; // finding the middle of the arrays

        mergeSort(array, start, midPoint); // dividing the array to left array
        mergeSort(array, midPoint, end); // and right array

        int[] tempArray = new int[end]; // temporary array for the merging faze;

        int i = start; // index of the left array
        int j = midPoint; // index of the right array
        int k = start; // index of the temporary array

        while (i < midPoint && j < end) { // comparing the right/left array values and copying them to the temp array
            if (array[i] < array[j]) {
                tempArray[k] = array[i];
                i++; //
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        while (k < tempArray.length) { // copying the rest of the values to the temp array
            if (i == midPoint) {
                tempArray[k] = array[j];
                j++;
            } else if (j == end) {
                tempArray[k] = array[i];
                i++;
            }
            k++; // next index of the temp array
        }

        for (int l = start; l < end; l++) { // copying the temp array to the original
            array[l] = tempArray[l];
        }
    }

    public void shellSort() {

        int gap = array.length / 2;

        for (int i = gap; i > 0; i/=2) { // every time we divide the gap by 2 until it becomes Insertion Sort
            for (int j = 0; j < array.length - i; j++) {
                int num = array[i + j]; // storing the element we want to sort
                int index = j; // positions we want to move and compare the element
                while (index >= 0 && num < array[index]) {
                    array[index + i] = array[index];
                    index-=i;
                }
                array[index + i] = num;
            }
        }
    }

    public void insertionSort() {

        for (int i = 1; i < array.length; i++) { // starting from 1 because [0] is already sorted
            int num = array[i]; // storing the element we want to sort
            int index = i - 1; // positions we want to move and compare the element
            while (index >= 0 && num < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = num;
        }
    }

    public void selectionSort() {

        int length = array.length;

        while (length != 0) { // while all elements are unsorted
            int biggestNum = 0;
            for (int i = 1; i < length; i++) {
                if (array[biggestNum] < array[i]) { // finding the index with the biggest value
                    biggestNum = i;
                }
            }
            int lastIndex = array[length-1]; // storing the last unsorted value and swapping it with the biggest unsorted value
            array[length-1] = array[biggestNum];
            array[biggestNum] = lastIndex;
            length--; // decrementing until there are no more values to be sorted
        }
    }

    public void bubbleSort() {

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
