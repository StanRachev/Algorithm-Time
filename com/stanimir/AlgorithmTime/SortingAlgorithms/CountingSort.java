package stanimir.AlgorithmTime.SortingAlgorithms;

public class CountingSort {

    public static void sort(int[] array) {

        int biggestNumber = array[0];

        for (int i = 1; i < array.length; i++) {
            if (biggestNumber < array[i]) {
                biggestNumber = array[i];
            }
        }

        int[] sortArray = new int[biggestNumber];

        for (int k : array) {
            sortArray[k - 1]++;
        }

        int y = 0;

        for (int i = 0; i < sortArray.length; i++) { // i = 0
            if (sortArray[i] != 0) {
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
}
