import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public int typeOfSort() {

        System.out.printf("""
                1. Test integer array against Bubble, Selection, Insertion, Shell, Merge and Quick sort.
                2. Test integer array against Counting sort (only positive values).
                3. Test integer array against Radix Sort (only positive and same width values).
                """);

        int userInput = 0;
        System.out.print("-> ");

        do {
            Scanner scan = new Scanner(System.in);
            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("Value for 1 to 3");
            }
        } while (userInput < 1 || userInput > 3);

        System.out.println();

        return userInput;
    }

    public int typeOfArray() {

        System.out.print("""
                1. Create custom array.
                2. Generate random array.
                """);

        System.out.print("-> ");

        int userInput = 0;

        do {
            Scanner scan = new Scanner(System.in);
            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("Value for 1 to 2");
            }
        } while (userInput < 1 || userInput > 2);

        System.out.println();

        return userInput;
    }

    public int[] sizeOfArray(int typeOfSort) {

        Scanner scan = new Scanner(System.in);

        if (typeOfSort == 2) {

            System.out.println("Size of the array (max 100 000), min value and max value (comma separated list):");
            System.out.print("-> ");

            String userInput = scan.nextLine();

            Scanner scanner = new Scanner(userInput);

            String[] userInputParameters = new String[3];
            int[] userInputParametersInt = new int[3];

            for (int i = 0; i < 3; i++) {
                userInputParameters[i] = scanner.useDelimiter(",").next().replaceAll("\\s", "");
                userInputParametersInt[i] = Integer.parseInt(userInputParameters[i]);
            }

            return userInputParametersInt;
        }

        System.out.println("Size of the array (max 100 000)");
        System.out.print("-> ");

        int userInput = scan.nextInt();

        return new int[]{userInput};
    }

    public void createCustomArray() {

        System.out.printf("%nEnter values, separated with commas%n");
        System.out.print("-> ");
    }
}