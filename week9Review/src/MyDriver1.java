import java.util.*;

@SuppressWarnings("Duplicates")
public class MyDriver1 {

    public static void main(String[] args) {
        println("=========== STARTING MY DRIVER 1 ============");
        printDivider();
        bagTrace();
        listInterfaceTrace();
        listTrace();
        testMergeList();
        testMergeAList();
        testMergeBags();
        testContainsDuplicates();
        testGetCurrentBagSize();
        testGetFrequencyOfAList();
    }

    public static void testGetFrequencyOfAList() {
        printNameOfCurrMethod();

        ListInterface<Integer> noDuplicatesList = new AList<>();
        noDuplicatesList.add(1);
        noDuplicatesList.add(2);
        noDuplicatesList.add(3);

        ListInterface<Integer> listWithDuplicates = new AList<>();
        listWithDuplicates.add(4);
        listWithDuplicates.add(6);
        listWithDuplicates.add(8);
        listWithDuplicates.add(10);
        listWithDuplicates.add(8);

        ListInterface<String> listWithDuplicateStrings = new AList<>();
        listWithDuplicateStrings.add("harry");
        listWithDuplicateStrings.add("james");
        listWithDuplicateStrings.add("barron");
        listWithDuplicateStrings.add("harry");
        listWithDuplicateStrings.add("james");
        listWithDuplicateStrings.add("harry");


        println(((AList<Integer>) noDuplicatesList).getFrequencyOf(5)); // 0
        println(((AList<Integer>) noDuplicatesList).getFrequencyOf(3)); // 1
        println(((AList<Integer>) listWithDuplicates).getFrequencyOf(8)); // 2
        println(((AList<String>) listWithDuplicateStrings).getFrequencyOf("harry")); // 3
        println(((AList<String>) listWithDuplicateStrings).getFrequencyOf("barron")); // 1
        println(((AList<String>) listWithDuplicateStrings).getFrequencyOf("ken")); // 0

    }

    public static void testGetCurrentBagSize() {
        printNameOfCurrMethod();
        BagInterface<Integer> bag1 = new ArrayBag<>();
        BagInterface<Integer> bag2 = new ArrayBag<>();
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);
        bag1.add(5);

        println(getCurrentSize(bag1)); // 5
        println(Arrays.toString(bag1.toArray()));
        println(getCurrentSize(bag2)); // 0
        println(Arrays.toString(bag2.toArray()));
    }

    /**
     * Get the size of a bag
     * @param bag bag to check
     * @param <T> generic
     * @return count of the number of items in the bag
     */
    public static <T> int getCurrentSize(BagInterface<T> bag) {
        int count = 0;
        BagInterface<T> tempBag = new ArrayBag<>();

        while(!bag.isEmpty()) {
            tempBag.add(bag.remove());
            count++;
        }

        while(!tempBag.isEmpty()) {
            bag.add(tempBag.remove());
        }

        return count;
    }

    public static void testContainsDuplicates() {
        printNameOfCurrMethod();

        ListInterface<Integer> noDuplicatesList = new AList<>();
        noDuplicatesList.add(1);
        noDuplicatesList.add(2);
        noDuplicatesList.add(3);

        ListInterface<Integer> listWithDuplicates = new AList<>();
        listWithDuplicates.add(4);
        listWithDuplicates.add(6);
        listWithDuplicates.add(8);
        listWithDuplicates.add(10);
        listWithDuplicates.add(8);

        ListInterface<String> listWithDuplicateStrings = new AList<>();
        listWithDuplicateStrings.add("harry");
        listWithDuplicateStrings.add("james");
        listWithDuplicateStrings.add("barron");
        listWithDuplicateStrings.add("harry");
        listWithDuplicateStrings.add("kenith");

        ListInterface<Integer> singeltonList = new AList<>();
        singeltonList.add(4);

        ListInterface<Integer> emptyList = new AList<>();



        println(containsDuplicates(noDuplicatesList)); // false
        println(containsDuplicates(listWithDuplicates)); // true
        println(containsDuplicates(listWithDuplicateStrings)); // true
        println(containsDuplicates(singeltonList)); // false
        println(containsDuplicates(emptyList)); // false
    }

    /**
     * Checks if a list that implements ListInterface contains duplicates
     * @param list the list to check for duplicates
     * @return true if the list contains duplicates otherwise return false
     */
    private static <T> boolean containsDuplicates(ListInterface<T> list) {
        boolean result = false;
        Set<T> items = new HashSet();

        if (!list.isEmpty()) {
            for(int i = 1; i <= list.getLength(); i++) {
                T item = list.getEntry(i);
                if (items.contains(item)) { return true; }
                else { items.add(item); }
            }
        }

        return result;
    }

    private static void testMergeBags() {
        BagInterface<Integer> bag1 = new ArrayBag<>();
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);

        BagInterface<Integer> bag2 = new ArrayBag<>();
        bag2.add(4);
        bag2.add(6);
        bag2.add(8);
        bag2.add(10);

        println(Arrays.toString(mergeBags(bag1, bag2).toArray()));
    }

    /**
     * Merges two bags into a new bag
     * @param bag1 first bag to merge
     * @param bag2 second bag to merge
     * @return new bag that contains items from bag1 & bag2
     */
    private static <T> BagInterface<T> mergeBags(BagInterface<T> bag1, BagInterface<T> bag2) {
        BagInterface<T> mergedBag = new ArrayBag<>();

        while (!bag1.isEmpty() || !bag2.isEmpty()) {
            if (!bag1.isEmpty()) { mergedBag.add(bag1.remove()); }
            if (!bag2.isEmpty()) { mergedBag.add(bag2.remove()); }
        }

        return mergedBag;
    }


    private static void testMergeAList() {
        printNameOfCurrMethod();

        ListInterface<Integer> shortList = new AList<>();
        shortList.add(1);
        shortList.add(2);
        shortList.add(3);

        ListInterface<Integer> longList = new AList<>();
        longList.add(4);
        longList.add(6);
        longList.add(8);
        longList.add(10);

        ListInterface<Integer> emptyList = new AList<>();

        println(Arrays.toString(mergeAList(shortList, longList).toArray()));
        println(Arrays.toString(mergeAList(longList, shortList).toArray()));
        println(Arrays.toString(mergeAList(emptyList, shortList).toArray()));
        println(Arrays.toString(mergeAList(emptyList, emptyList).toArray()));
    }

    /**
     * Merge two lists that implement ListInterface
     * @param list1 list 1
     * @param list2 list 2
     * @return new list created from merging list1 & list2
     */
    private static <T extends Comparable> ListInterface<T> mergeAList(ListInterface<T> list1, ListInterface<T> list2) {
        ListInterface<T> mergedList = new AList<>();

        int count = 1;
        while ((count <= list1.getLength()) || (count <= list2.getLength())) {
            if (count <= list1.getLength()) { mergedList.add(list1.getEntry(count)); }
            if (count <= list2.getLength()) { mergedList.add(list2.getEntry(count)); }
            count++;
        }

        return mergedList;
    }

    private static void testMergeList() {
        printNameOfCurrMethod();

        Integer[] shortArr = {1, 2, 3};
        Integer[] longArr = {4, 6, 8, 10};
        Integer[] emptyArr = {};

        List<Integer> shortList = new ArrayList<>(Arrays.asList(shortArr));
        List<Integer> longList = new ArrayList<>(Arrays.asList(longArr));
        List<Integer> emptyList = new ArrayList<>(Arrays.asList(emptyArr));

        println(mergeList(shortList, longList));
        println(mergeList(longList, shortList));
        println(mergeList(emptyList, shortList));
        println(mergeList(emptyList, emptyList));

    }

    /**
     * Merge two lists that implement Java's List interface
     * @param list1 list 1
     * @param list2 list 2
     * @return new list created from merging list1 & list2
     */
    private static List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        Iterator<Integer> itr1 = list1.iterator();
        Iterator<Integer> itr2 = list2.iterator();

        while(itr1.hasNext() || itr2.hasNext()) {
            if (itr1.hasNext()) { mergedList.add(itr1.next()); }
            if (itr2.hasNext()) { mergedList.add(itr2.next()); }
        }

        return mergedList;
    }

    /*
        What does it mean to use a bag or list as a client (to use an interface)? What can you access?

        Using a bag or list as a client means that you are using some implementation of a the bag or list interface.
        You can access properties and methods that have been made public.

     */

    private static void listTrace() {
        printNameOfCurrMethod();
        List<String> nameList = new ArrayList<>();

        System.out.println(nameList.isEmpty()); // Output: true
        nameList.add("adam"); // Output: true
        nameList.add("brian"); // Output: true
        nameList.add("carl"); // Output: true
        nameList.add("edgar"); // Output: true
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "carl", "edgar"]
        nameList.add(3, "hank"); // Output: null
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "carl", "hank", "edgar"]
        nameList.add("lenny"); // Output: true
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "brian", "carl", "hank", "edgar", "lenny"]
        nameList.add(1, "mark"); // Output: null
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "mark", "brian", "carl", "hank", "edgar", "lenny"]
        System.out.println(nameList.size()); // Output: 7
        System.out.println(nameList.get(3)); // Output: carl
        System.out.println(nameList.remove(2)); // Output: brian
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "mark", "carl", "hank", "edgar", "lenny"]
        System.out.println(nameList.get(2)); // Output: carl
        System.out.println(nameList.remove(1)); // Output: mark
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "carl", "hank", "edgar", "lenny"]
        System.out.println(nameList.remove(2)); // Output: hank
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "carl", "edgar", "lenny"]
        System.out.println(nameList.size()); // Output: 4
        System.out.println(nameList.set(2, "peter")); // Output: edgar
        println(">>>>> " + Arrays.toString(nameList.toArray())); // Contents: ["adam", "carl", "peter", "lenny"]
        System.out.println(nameList.get(2)); // Output: peter
        System.out.println(nameList.get(1)); // Output: carl
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

    public static <T> void printAList(ListInterface<T> aList) {
        print("AList: [ ");
        for(int i = 1; i <= aList.getLength(); i++) {
         print(aList.getEntry(i));
         print(" ");
        }
        println("]");
    }

}




