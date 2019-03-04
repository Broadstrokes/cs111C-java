import java.util.Arrays;
import java.util.List;

public class MorePracticeDriver {
    public static void main(String[] args) {
        printDashes();
        printNameOfCurrMethod();


        int[] arr1 = {0 , 3 , 1, 3, 2, 4};
        int[] arr2 = {3 , 5 , 7, 3};
        int[] arr3 = {1};
        int[] arr4 = {2};
        int[] arr5 = {2, 4, 6, 8, 10};
        int[] arr6 = {2, 4, 5, 8, 10};



        int[] arr7 = {3, 4, 6, 7, 8, 10, 4};
        int[] arr8 = {1, 4, 6, 3, 2, 7, 8};

//        Node<Integer>

//        println(methodA(4));
//        println(methodA(0));
//        println(methodA(-3));

//        println(methodB("eieio",'e'));
//        println(methodB("hello there",'h'));

//        println(countEvens(arr1));
//        println(countEvens(arr2));
//        println(countEvens(arr3));
//        println(countEvens(arr4));
//        println(countEvens(arr5));
//        println(countEvens(arr6));


//        recMethod(arr7, 2,5);
//        recMethod(arr8, 3,2);
        recMethod(arr8, 3,8);


    }


    public static void recMethod(int[] array, int start, int end) {
        if(start < end) {
            println(Arrays.toString(array));
            array[start] *= 2;
            recMethod(array, start+1, end);
            println(Arrays.toString(array));

        } else {
            println("done");
        }
    }


    public static int countEvens(int[] array) {
        printNameOfCurrMethod();
        return countEvensHelper(array, 0, array.length);
    }

    private static int countEvensHelper(int[] array, int start, int stop) {
        int count = 0;
        if(start==stop) {
            return count;
        } else {
            if(array[start] % 2 == 0) {
                count = 1 + countEvensHelper(array, start+1, stop);
            }
            return count;
        }
    }


    public static int methodB(String s, char c) {
        if(s.length()==0) {
            return 0;
        } else {
            return (s.charAt(0)==c ? 1 : 0) + methodB(s.substring(1), c);
        }
    }


    public static int methodA(int n) {
        if(n==0) {
            return 0;
        } else if(n>0) {
            return 1 + methodA(n-1);
        } else {
            return 1 + methodA(n+1);
        }
    }


    /*
        HELPER FUNCTIONS
     */

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

