import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class MyDriver1 {

    public static void main(String[] args) {
        println("=========== STARTING MY DRIVER 1 ============");
        test1();
    }

    private static void test1() {
        ArrayBag<String> nameBag = new ArrayBag<>();

        System.out.println(nameBag.isEmpty());
       // Bag Contents: []
        nameBag.add("adam");
       // Bag Contents: ["adam"]
        nameBag.add("brian");
       // Bag Contents: ["adam", "brian"]
        nameBag.add("carl");
       // Bag Contents: ["adam", "brian", "carl"]
        nameBag.add("adam");
       // Bag Contents: ["adam", "brian", "carl", "adam"]
        nameBag.add("fred");
       // Bag Contents: ["adam", "brian", "carl", "adam", "fred"]
        nameBag.add("carl");
       // Bag Contents: ["adam", "brian", "carl", "adam", "fred", "carl"]
        nameBag.add("harry");
       // Bag Contents: ["adam", "brian", "carl", "adam", "fred", "carl", "harry"]
        nameBag.add("hank");
       // Bag Contents: ["adam", "brian", "carl", "adam", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("adam")); // Output: true
       // Bag Contents: ["brian", "carl", "adam", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getCurrentSize()); // Output: 7
       // Bag Contents: ["brian", "carl", "adam", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("adam")); // Output: true
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("adam")); // Output: false
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("ivan")); // Output: false
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getCurrentSize()); // Output: 6
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getFrequencyOf("carl")); // Output: 2
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.contains("ivan")); // Output: false
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getFrequencyOf("ivan")); // Output: 0
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.contains("ivan")); // Output: false
       // Bag Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        nameBag.clear();
       // Bag Contents: []
        System.out.println(nameBag.getCurrentSize()); // Output: 0
       // Bag Contents: []
    }



    /*
        HELPER FUNCTIONS
     */


    /**
     * Test if a string is blank or null and return original string or "NA" if string is empty or null
     * @param str the string to test
     * @return original string or "NA" if string is empty or null
     */
    public static String isBlank(String str) {
        if (str == null || (str.length() == 0)) { str = "NA"; }
        return str;
    }

    public static void println(Object line) { System.out.println(line); }

    public static void print(Object line) { System.out.print(line); }

    public static void printDashes() { println("----------------------------"); }

    public static void printNameOfCurrMethod() {
        String nameOfCurrMethod =
                new Throwable()
                        .getStackTrace()[1]
                        .getMethodName();

        println("*********** Running: " + nameOfCurrMethod + " **************");
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




