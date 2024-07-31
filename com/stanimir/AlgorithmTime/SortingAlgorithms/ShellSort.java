package stanimir.AlgorithmTime.SortingAlgorithms;

public class ShellSort {

    public static void sort(int[] array) {

        int gap = array.length / 2;

        // every time we divide the gap by 2 until it becomes Insertion stanimir.AlgorithmTime.Sort
        for (int i = gap; i > 0; i/=2) {
            for (int j = 0; j < array.length - i; j++) {

                // storing the element we want to sort
                int num = array[i + j];

                // positions we want to move and compare the element
                int index = j;
                while (index >= 0 && num < array[index]) {
                    array[index + i] = array[index];
                    index-=i;
                }
                array[index + i] = num;
            }
        }
    }
}
