package com.company;

public class Main {

    public static void main(String[] args) {
        test(isEligibleForLoan(3000, 1) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(50000, 1) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(51000, 2) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(150000, 2) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(151000, 0) == true, "passed", "failed", "return true");
        test(isEligibleForLoan(51000, 2.5) == true, "passed", "failed", "return true");
        test(sumRange(1, 10) == 55, "passed", "failed", "return 55");



        Computer myImac = new Computer();
        println(myImac);

        Computer myLenovo = new Computer("Lenovo X1", "1TB");
        println(myLenovo);

        Computer myWorkLenovo = new Computer("Lenovo X1", "1TB");

        test(myImac.equals(myLenovo) == false, "passed", "failed", "should return false");
        test(myWorkLenovo.equals(myLenovo) == true, "passed", "failed", "should return true");

        UndergraduateStudent jimmy = new UndergraduateStudent("Jim", "Raynor", 11, false);
        println(jimmy);

        // ------------------------------ // ------------------------------ // ------------------------------

        println(">>>>>>>>>Method 1<<<<<<<<<<<<");
        Student e = new Student("jay", "ka", 10);
        method1(e);
        System.out.println(e.getStudentID());


        println(">>>>>>>>>Method 2<<<<<<<<<<<<");
//        int[] numbers = {0, 0, 0};
//        method2(numbers);
//
//        System.out.println(numbers[1]);


        println(">>>>>>>>>Method 3<<<<<<<<<<<<");
        int[] numbers = {0, 0, 0};
        method3(numbers);
        System.out.println(numbers[1]);



        Student p = new UndergraduateStudent("Daymond", "John", 333, true);
        println(p.toString());

        Object xavier = new Student("an", "be", 33);

        Student[] parents = new Student[3];
        parents[0] = new UndergraduateStudent("Can", "Can", 99);


        // ------------------------------ // ------------------------------ // ------------------------------
        Parcel amazonPrime = new Parcel("bn23", 33.4);
        println(amazonPrime);


        OvernightParcel fedex = new OvernightParcel("fedex44", 61.3, false);
        println(fedex);

//
//        Parcel usps = new Parcel("bn23", 33.4);
//        Parcel dhl = new Parcel("bn1234");
//        System.out.println(usps.toString());
//        System.out.println(dhl.toString());
//
//        println(">>>>>>>>>Parcels Equals<<<<<<<<<<<<");
//
//        println(usps.equals(amazonPrime));
//        System.out.println(usps.equals(fedex));
//        System.out.println(dhl.equals(usps));
//


        println(isValidEmail("Ha.jim"));
        println(isValidEmail("Haji"));
        println(isValidEmail("@Haji"));
        println(isValidEmail("Haji@"));
        println(isValidEmail("@@Haji@."));


        println(">>>>>>><<<<<<<<<<<<<<");


        println(isValidEmail("a@g.cm"));
        println(isValidEmail("agba.com"));
        println(isValidEmail("a@g.comm"));
        println(isValidEmail("a@g.com"));
    }

    // ------------------------------ // ------------------------------ // ------------------------------

    public static void method1(Student e) {
        e.setStudentID(99);
    }


    public static void method2(int[] numbers) {
        numbers[1] = 43;
    }

    public static void method3(int[] numbers) {
        numbers = new int[3];
        numbers[0] = 43;
        numbers[1] = 43;
        numbers[2] = 43;
    }

    // ------------------------------ // ------------------------------ // ------------------------------


    public static boolean isValidEmail(String input) {
        int len = input.length();
        final int numCharactersRequiredAfterPeriod = 3;

        if (len < 7) {
            return false;
        } else if (
            input.contains(".") &&
            input.contains("@") &&
            len - input.lastIndexOf(".") - 1  == numCharactersRequiredAfterPeriod
        ) {
            return true;
        }
        else {
            return false;
        }
    }


    public static boolean isEligibleForLoan(double income, double numYearsAtCurrentWorkPlace) {
        if (income > 150000) return true;
        else if (income < 50000) return false;
        else return numYearsAtCurrentWorkPlace > 2;
    }


    public static int sumRange(int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void println(Object line) { System.out.println(line); }
    public static void print(Object line) { System.out.print(line); }

    /**
     * Function to test an expectation
     * @param expression     Expectation/Expression to test, which returns a boolean
     * @param successMessage String to output to the user if the expectation is met
     * @param errorMessage   String to output to the user if the expectation is not met
     * @param should         String stating what should be tested
     */
    public static void test (boolean expression, String successMessage, String errorMessage, String should) {
        System.out.print(should + ": ");

        if (expression)
            System.out.println(successMessage);
        else
            System.out.println(errorMessage);
    }
}
