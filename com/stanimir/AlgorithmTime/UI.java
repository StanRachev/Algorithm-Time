package stanimir.AlgorithmTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class UI {

    BufferedReader reader;

    public UI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private int makeChoice(int upperBound) {
        int userInput = 0;
        while (userInput < 1 || userInput > upperBound) {
            try {
                userInput = Integer.parseInt(reader.readLine());
            } catch (IOException | InputMismatchException | NumberFormatException a) {
                System.out.printf("Value from 1 to %d", upperBound);
                System.out.println();
            }
        }

        return userInput;
    }

    public int typeOfSort() {
        System.out.print("""
                1. Test integer array against Bubble, Selection, Insertion, Shell, Merge and Quick sortClass.
                2. Test integer array against Counting sortClass (only positive values).
                3. Test integer array against Radix Sort (only positive and same width values).
                """);
        System.out.print("-> ");

        int userInput = makeChoice(3);

        System.out.println();

        return userInput;
    }

    public int enterOrGenerateArray() {

        System.out.print("""
                1. Create custom array.
                2. Generate random array (with values 1 - 100_000).
                """);

        System.out.print("-> ");

        int userInput = makeChoice(2);
        System.out.println();

        return userInput;
    }

    public int enterSizeOfArray() {

        System.out.println("Size of the array (max 100 000)");
        System.out.print("-> ");

        return makeChoice(100_000);
    }

    public void createCustomArray() {

        System.out.printf("%nEnter values, separated with commas%n");
        System.out.print("-> ");
    }
}