public class MyM5Driver {
    public static void main (String[] args) {
        println("******** Starting my driver for M5 ************");
    }

    /*
        HELPER FUNCTIONS
    */

    public static void println(Object line) { System.out.println(line); }

    public static void print(Object line) { System.out.print(line); }

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
