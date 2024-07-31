package stanimir.AlgorithmTime.Util;

import java.util.Random;
import java.util.Scanner;

public class ArrayCreator {

    public static int[] createCustomArray(int size) {
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

    public static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(0, 100_000);
        }

        return array;
    }

    public static int[] copyArray(int[] array) {
        int[] arrToSort = new int[array.length];
        System.arraycopy(array, 0, arrToSort, 0, array.length);

        return arrToSort;
    }
}
