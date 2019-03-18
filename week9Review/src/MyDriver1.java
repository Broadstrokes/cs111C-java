import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class MyDriver1 {

    public static void main(String[] args) {
        println("=========== STARTING MY DRIVER 1 ============");
        printDivider();
        bagTrace();
        listInterfaceTrace();
    }


    private static void listInterfaceTrace() {
        printNameOfCurrMethod();
        ListInterface<String> nameList = new AList<>();

        System.out.println(nameList.isEmpty()); // Output: true
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: []
        nameList.add("adam");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam"]
        nameList.add("brian");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian"]
        nameList.add("carl");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "carl"]
        nameList.add("edgar");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "carl", "edgar"]
        nameList.add(3, "hank");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "hank", "carl", "edgar"]
        nameList.add("lenny");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "hank", "carl", "edgar", "lenny"]
        nameList.add(1, "mark");
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["mark", "adam", "brian", "hank", "carl", "edgar", "lenny"]
        System.out.println("Length: " + nameList.getLength()); // Output: 7
        System.out.println("Entry at position 3: " + nameList.getEntry(3)); // Output: brian
        System.out.println("Length: " + nameList.getLength()); // Output: 7
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["mark", "adam", "brian", "hank", "carl", "edgar", "lenny"]
        System.out.println("Remove from position 2: " + nameList.remove(2)); // Output: adam
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["mark", "brian", "hank", "carl", "edgar", "lenny"]
        System.out.println(nameList.getEntry(2)); // Output: carl
        System.out.println("Remove from position 1: " + nameList.remove(1)); // Output: mark
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["brian", "hank", "carl", "edgar", "lenny"]
        System.out.println("Remove from position 2: " + nameList.remove(2)); // Output: hank
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["brian", "carl", "edgar", "lenny"]
        System.out.println(nameList.getLength()); // Output: 4
        System.out.println("Replace at position 2: " + nameList.replace(2, "peter")); // Output: carl
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["brian", "peter", "edgar", "lenny"]
        System.out.println("Entry at position 2: " + nameList.getEntry(2)); // Output: peter
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["brian", "peter", "edgar", "lenny"]
        System.out.println("Entry at position 1: " + nameList.getEntry(1)); // Output: brian
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["brian", "peter", "edgar", "lenny"]
        System.out.println("Length: " + nameList.getLength()); // Output: 4
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["brian", "peter", "edgar", "lenny"]
    }

    private static void bagTrace() {
        printNameOfCurrMethod();
        BagInterface<String> nameBag = new ArrayBag<>();

        System.out.println(nameBag.isEmpty());
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: []
        nameBag.add("adam");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam"]
        nameBag.add("brian");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian"]
        nameBag.add("carl");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian", "carl"]
        nameBag.add("adam");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian", "carl", "adam"]
        nameBag.add("fred");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian", "carl", "adam", "fred"]
        nameBag.add("carl");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian", "carl", "adam", "fred", "carl"]
        nameBag.add("harry");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian", "carl", "adam", "fred", "carl", "harry"]
        nameBag.add("hank");
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["adam", "brian", "carl", "adam", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("adam")); // Output: true
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "adam", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getCurrentSize()); // Output: 7
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "adam", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("adam")); // Output: true
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("adam")); // Output: false
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.remove("ivan")); // Output: false
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getCurrentSize()); // Output: 6
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getFrequencyOf("carl")); // Output: 2
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.contains("ivan")); // Output: false
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.getFrequencyOf("ivan")); // Output: 0
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        System.out.println(nameBag.contains("ivan")); // Output: false
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: ["brian", "carl", "fred", "carl", "harry", "hank"]
        nameBag.clear();
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: []
        System.out.println(nameBag.getCurrentSize()); // Output: 0
        println(">>>>> " + Arrays.toString(nameBag.toArray())); // Contents: []
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

    public static void printDashes() { println("------------------------------------------------"); }
    public static void printDivider() { println("\n\n"); }

    public static void printNameOfCurrMethod() {
        String nameOfCurrMethod =
                new Throwable()
                        .getStackTrace()[1]
                        .getMethodName();
        printDivider();
        printDashes();
        println("*********** Running: " + nameOfCurrMethod + " **************");
        printDashes();
        printDivider();
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




