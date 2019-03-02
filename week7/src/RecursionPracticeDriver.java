public class RecursionPracticeDriver {
    public static void main (String[] args) {
        printDashes();
        printNameOfCurrMethod();

        testPrintCharacter();

    }


    public static void testPrintCharacter() {
        String[] testStrings = {"", "h", "hello", "hellow"};
        for(String item : testStrings) {
            printDashes();
            println(item);
            printDashes();
            printEachCharacter(item, 0, item.length());
        }

    }




    public static void printEachCharacter(String input, int pointer, int len) {
        if (pointer == len) {
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