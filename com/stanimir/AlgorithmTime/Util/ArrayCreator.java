package stanimir.AlgorithmTime.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ArrayCreator {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int[] createCustomArray() {
        try {
            String[] userInput = reader.readLine().split("[^0-9]+");
            int[] userArrayInt = new int[userInput.length];

            for (int i = 0; i < userInput.length; i++) {
                userArrayInt[i] = Integer.parseInt(userInput[i]);
            }
            return userArrayInt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
