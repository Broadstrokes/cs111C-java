import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class MyM5Driver {
    public static void main (String[] args) {
        printDashes();
        println("Starting my driver for M5");
        printDashes();
        println("");

//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
//        test22();
//        test23();
        test24();
//        test();
//        test();



    }




    public static void test24() {
        printNameOfCurrMethod();
        printDashes();

        Node a = new Node(2);
        Node b = new Node(3, a);
        Node c = new Node(5, b);
        Node d = new Node(6, c);
        Node e = new Node(4, d);
        Node currentNode = e;
        Node nullNode = null;

//        recMethod(e);
//        recMethod(a);
//        recMethod(nullNode);

    }

    public static void recMethod(Node firstNode) {
        loopOverList(firstNode);
        if(firstNode.next!=null) {
            firstNode.data = 2 * (int) firstNode.data;
            recMethod(firstNode.next.next);
        } else {
            println("done");
        }
        loopOverList(firstNode);
    }



    public static void test23() {
        printNameOfCurrMethod();
        printDashes();

        Node a = new Node(9);
        Node b = new Node(8, a);
        Node c = new Node(6, b);
        Node d = new Node(4, c);
        Node currentNode = d;



        Node nullNode = null;
        Node singleton = new Node(1);


        printDashes();
//        method1(nullNode);
        printDashes();
        method1(singleton);
        printDashes();
        method1(currentNode);

//        printNameOfCurrMethod();
//        printDashes();
//        method2(nullNode);
//        printDashes();
//        method2(singleton);
//        printDashes();
//        method2(currentNode);

    }

    public static void method2(Node firstNode) {
        while(firstNode != null) {
            System.out.println(firstNode.data);
            firstNode = firstNode.next;
        }
    }

    public static void method1(Node firstNode) {
        Node secondNode = firstNode.next;
        Node currentNode = secondNode;

        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }


    public static void test22() {
        printNameOfCurrMethod();


        printDashes();
        Node head = generateList(new int[] {3, 8, 6, 12});
        loopOverList(head);
        println(countDivisibleBy(head, 3));
        printEveryOther(head);

        printDashes();
        Node head2 = generateList(new int[] {4, 5, 15, 8, 6});
        loopOverList(head2);
        println(countDivisibleBy(head2, 3));
        printEveryOther(head2);

        printDashes();
        Node head3 = generateList(new int[] {2, 7, 8});
        loopOverList(head3);
        println(countDivisibleBy(head3, 3));
        printEveryOther(head3);
    }

    public static void test13() {
        Node a = new Node(9);
        Node b = new Node(8, a);
        Node c = new Node(6, b);
        Node d = new Node(4, c);
        Node currentNode = d;

        printNameOfCurrMethod();

//        LList<Integer> numberList = new LList<Integer>();
        List<String> emptyList = new LinkedList<>();
        println(((LinkedList<String>) emptyList).getFirst());
//        method(((LinkedList<String>) emptyList).getFirst());
        List<Node> singletonList = new LinkedList<>();
        singletonList.add(new Node(3));
        method1(((LinkedList<Node>) singletonList).getFirst());


//        method(new Node(3));

    }



    public static void test12() {
        Node a = new Node(9);
        Node b = new Node(8, a);
        Node c = new Node(6, b);
        Node d = new Node(4, c);
        Node currentNode = d;

        printNameOfCurrMethod();

        while(currentNode.next != null) {
            System.out.print(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void test11() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(2, b);
        Node firstNode = c;
        Node currentNode = firstNode; // 2
        currentNode = currentNode.next; // 3
        currentNode = currentNode.next; // 5

        printNameOfCurrMethod();
        System.out.println(currentNode.next.data);
    }

    public static void test10() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(2, b);
        Node firstNode = c;
        Node currentNode = firstNode; // 2
        currentNode = currentNode.next; // 3
        currentNode = currentNode.next; // 5

        printNameOfCurrMethod();
        System.out.println(currentNode.next);
    }

    public static void test9() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        firstNode.next.next = firstNode.next.next.next;

        // 2 -> 7 -> 5
        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
    }

    public static void test8() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node e = new Node(6);
        e.next = firstNode.next;
        firstNode.next = e;

        // 2 -> 7 -> 3 -> 5
        // 2 -> 6 -> 7 -> 3 -> 5
        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
    }

    public static void test7() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode;
        currentNode.next = currentNode.next.next;

        // 2 -> 3 -> 5
        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
        println(currentNode.data); // 2
    }

    public static void test6() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode;
        firstNode = firstNode.next;

        // 7 -> 3 -> 5
        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
        println(currentNode.data); // 2
    }

    public static void test5() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode;
        currentNode = currentNode.next;

        // 2 -> 7 -> 3 -> 5
        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
        println(currentNode.data); // 7
    }

    public static void test4() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode;
        currentNode.next.next.data = 8;

        // 2 -> 7 -> 8 -> 5
        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
        println(currentNode.data); // 2
    }


    public static void test3() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode;
        currentNode.data = 15;

        // 15 -> 7 -> 3 -> 5

        printNameOfCurrMethod();
        loopOverList(firstNode);
        printDashes();
        println(currentNode.data); // 15
    }

    public static void test2() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode;

        // 2 -> 7 -> 3 -> 5

        loopOverList(firstNode);
        printDashes();
        println(currentNode.data);
    }

    public static void test1() {
        Node a = new Node(5);
        Node b = new Node(3, a);
        Node c = new Node(7, b);
        Node d = new Node(2, c);
        Node firstNode = d;
        Node currentNode = firstNode.next;

        // 2 -> 7 -> 3 -> 5

        loopOverList(firstNode);
        printDashes();
        println(currentNode.data);
    }







    /*
        LIST HELPER FUNCTIONS
    */

    public static void printEveryOther(Node firstNode) {
        int count = 0;
        Node currentNode = firstNode;

        while (currentNode != null) {
            if (count % 2 == 0) {
                print(currentNode.data);
            }
            count++;
            currentNode = currentNode.next;
        }
    }


    public static int countDivisibleBy(Node<Integer> firstNode, int divisor) {
        int count = 0;
        Node<Integer> currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.getData() % divisor == 0) count++;
            currentNode = currentNode.next;
        }

        return count;
    }


    public static void loopOverList(Node head) {
        Node currentNode = head;
        String stringifiedList = "";

        while(currentNode != null) {
            stringifiedList += currentNode.data;
            if (currentNode.next != null) { stringifiedList+= "->"; }
            currentNode = currentNode.next;
        }

        println(stringifiedList);
    }


    public static Node generateList(int[] arrayOfInts) {
        Node previousNode = null;

        for (int i = arrayOfInts.length - 1; i >= 0; i--) {
            println(">>> i: "  + i + " |  " + arrayOfInts[i]);
            Node newNode = new Node(arrayOfInts[i]);
            newNode.next = previousNode;
            previousNode = newNode;
        }

        return previousNode;
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
