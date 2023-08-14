import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UI ui = new UI();
        int typeOfSort = ui.typeOfSort();
        int typeOfArray = ui.typeOfArray();

        int[] arrayParameters = ui.sizeOfArray(typeOfArray); // sizeOfArray, lowerRange, upperRange
        int sizeOfArray = arrayParameters[0];
        int[] array;

        if (typeOfArray == 1) {
            ui.createCustomArray();
            array = customArray(sizeOfArray);
        } else {
            array = randomArray(sizeOfArray, arrayParameters[1], arrayParameters[2]);
        }

        Sort sort = new Sort(sizeOfArray, array);
//        printSortedArray(array, sort);
        double[] sortTime = returnSortTime(typeOfSort, array, sort);

        printSortTime(
                typeOfSort, sortTime); // Print the time it took for the sorting
    }

    public static void printSortedArray(int[] array, Sort sort) {

        System.out.println("Unsorted: " + Arrays.toString(array));
        sort.bubbleSort();
        System.out.println("Sorted: " + Arrays.toString(array));
    }

    public static double[] returnSortTime(int userChoiceSort, int[] array, Sort sort) {

        if (userChoiceSort == 1) {

            long bubbleStartTime = System.nanoTime();
            sort.bubbleSort();
            long bubbleEndTime = System.nanoTime();
            double elapsedBubble = (bubbleEndTime - bubbleStartTime) / 1e6;

            long selectionStartTime = System.nanoTime();
            sort.selectionSort();
            long selectionEndTime = System.nanoTime();
            double elapsedSelection = (selectionEndTime - selectionStartTime) / 1e6;

            long insertionStartTime = System.nanoTime();
            sort.insertionSort();
            long insertionEndTime = System.nanoTime();
            double elapsedInsertion = (insertionEndTime - insertionStartTime) / 1e6;

            long shellStartTime = System.nanoTime();
            sort.shellSort();
            long shellEndTime = System.nanoTime();
            double elapsedShell = (shellEndTime - shellStartTime) / 1e6;

            long quickStartTime = System.nanoTime();
            sort.quickSort(array, 0, array.length);
            long quickEndTime = System.nanoTime();
            double elapsedQuick = (quickEndTime - quickStartTime) / 1e6;

            long mergeStartTime = System.nanoTime();
            sort.mergeSort(array, 0, array.length);
            long mergeEndTime = System.nanoTime();
            double elapsedMerge = (mergeEndTime - mergeStartTime) / 1e6;

            return new double[]{
                    elapsedBubble, elapsedSelection, elapsedInsertion,
                    elapsedShell , elapsedMerge, elapsedQuick
            };

        } else if (userChoiceSort == 2) {

            long countingStartTime = System.nanoTime();
            sort.countingSort();
            long countingEndTime = System.nanoTime();
            double elapsedCounting = (countingEndTime - countingStartTime) / 1e6;

            return new double[]{elapsedCounting};

        } else {

            long radixStartTime = System.nanoTime();
            sort.radixSort();
            long radixEndTime = System.nanoTime();
            double elapsedRadix = (radixEndTime - radixStartTime) / 1e6;

            return new double[]{elapsedRadix};
        }


    }

    public static void printSortTime(int userChoiceSort, double... sort) {

        double[] sorts;
        sorts = sort;

        if (userChoiceSort == 1) {

            System.out.printf("%n%-20s%-15f%s", "Bubble sort:", sorts[0], "milliseconds.");
            System.out.printf("%n%-20s%-15f%s", "Selection sort:", sorts[1], "milliseconds.");
            System.out.printf("%n%-20s%-15f%s", "Insertion sort:", sorts[2], "milliseconds.");
            System.out.printf("%n%-20s%-15f%s", "Shell sort:", sorts[3], "milliseconds.");
            System.out.printf("%n%-20s%-15f%s", "Merge sort:", sorts[4], "milliseconds.");
            System.out.printf("%n%-20s%-15f%s%n", "Quick sort:", sorts[5], "milliseconds.");

        } else if (userChoiceSort == 2) {

            System.out.printf("%n%-20s%-10f%s%n", "Counting sort:", sorts[0], "milliseconds.");

        } else {

            System.out.printf("%n%-20s%-10f%s%n", "Radix sort:", sorts[0], "milliseconds.");
        }
    }

    public static int[] customArray(int size) {

        Scanner scan = new Scanner(System.in);

        String userInput = scan.nextLine();

        Scanner scanner = new Scanner(userInput);
        String[] userInputParameters = new String[size];
        int[] userInputParametersInt = new int[size];

        for (int i = 0; i < size; i++) {
            userInputParameters[i] = scanner.useDelimiter(",").next().replaceAll("\\s", "");
            userInputParametersInt[i] = Integer.parseInt(userInputParameters[i]);
        }

        return userInputParametersInt;
    }

    public static int[] randomFourDigitArray(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000, 6000);
        }

        return array;
    }

    public static int[] randomArray(int size, int lowerRange, int upperRange) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(lowerRange, upperRange);
        }

        return array;
    }
}