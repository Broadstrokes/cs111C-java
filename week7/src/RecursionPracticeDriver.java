import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.List;

public class RecursionPracticeDriver {
    public static void main (String[] args) {
        printDashes();
        printNameOfCurrMethod();

        testPrintCharacter();
        testPrintDoubleArray();
        testPrintEveryOther();
    }


    public static void testPrintCharacter() {
        String[] testStrings = {"", "h", "hello", "hellow"};
        for(String item : testStrings) {
            printDashes();
            println(item);
            printDashes();
            printEachCharacter(item, 0, item.length());
        }

        printDashes();
        println(" TEST print without extra params");
        printDashes();


        for(String item : testStrings) {
            printDashes();
            println(item);
            printDashes();
            printEachCharacter(item);
        }


        printDashes();
        println(" TEST print in reverse");
        printDashes();

        for(String item : testStrings) {
            printDashes();
            println(item);
            printDashes();
            printCharactersInReverse(item);
        }

    }


    public static void testPrintDoubleArray() {
        int[][] testArrays = {
            {},
            {100},
            {1, 2, 3, 4},
            {-1, -2, -3, -4, -55}
        };

        for(int[] array : testArrays) {
            printDashes();
            println(Arrays.toString(array));
            doubleElementsInAnArray(array, 0, array.length);
            println(Arrays.toString(array));
            printDashes();
        }

        printDashes();
        println(" TEST doubling array without having the user pass extra params");
        printDashes();

        for(int[] array : testArrays) {
            printDashes();
            println(Arrays.toString(array));
            doubleElementsInAnArray(array);
            println(Arrays.toString(array));
            printDashes();
        }



    }


    public static void testPrintEveryOther() {
        int[][] testArrays = {
                {},
                {100},
                {1, 2, 3, 4},
                {-1, -2, -3, -4, -55}
        };

        for(int[] array : testArrays) {
            printDashes();
            println(Arrays.toString(array));
            printEveryOther(array);
            printDashes();
        }
    }

    public static void printEveryOther(int[] nums) {
        printEveryOtherRecurser(nums, 0);
    }

    public static void printEveryOtherRecurser(int[] nums, int pointer) {
        if (pointer >= nums.length) {
            System.out.println("End recursion");
        } else {
            System.out.println(nums[pointer]);
            printEveryOtherRecurser(nums, pointer + 2);
        }
    }

    public static void doubleElementsInAnArray(int[] input) {
        doubleElementsInAnArray(input, 0, input.length);
    }

    public static void doubleElementsInAnArray(int[] input, int pointer, int len) {
        if(pointer >= len)  {
            println("End recursion");
        } else {
            input[pointer] *= 2;
            doubleElementsInAnArray(input, pointer + 1, len);
        }
    }

    public static void printCharactersInReverse(String input) {
        if (input.length() == 0) { println("End recursion"); }
        else {
            if (input.length() > 0) {
                printCharactersInReverse(input.substring(1));
            }
            println(input.charAt(0));
        }
    }

    public static void printEachCharacter(String input) {
        if (input.length() == 0) {
           println("End recursion");
        } else {
            println(input.charAt(0));
            printEachCharacter(input.substring(1));
        }
    }

    public static void printEachCharacter(String input, int pointer, int len) {
        if (pointer >= len) {
            println("End recursion");
        } else {
            char curr = input.charAt(pointer);
            println(curr);
            printEachCharacter(input, pointer + 1, len);
        }
    }


    /*
        HELPER FUNCTIONS
     */

    public static void println(Object line) { System.out.println(line); }
    public static void print(Object line) { System.out.print(line); }
    public static void printDashes() { println( "----------------------------"); }
    public static void printNameOfCurrMethod() {
        String nameOfCurrMethod =
                new Throwable()
                        .getStackTrace()[1]
                        .getMethodName();

        println( "*********** Running: " + nameOfCurrMethod + " **************");
    }

    /**
     * Function to test an expectation
     *
     * @param expression     Expectation/Expression to test, which returns a boolean
     * @param successMessage String to output to the user if the expectation is met
     * @param errorMessage   String to output to the user if the expectation is not met
     * @param should         String stating what should be tested
     */
    public static void test(boolean expression, String successMessage, String errorMessage, String should) {
        System.out.print(should + ": ");

        if (expression)
            System.out.println(successMessage);
        else
            System.out.println(errorMessage);
    }

}
