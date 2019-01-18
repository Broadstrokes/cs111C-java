package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        test(isEligibleForLoan(3000, 1) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(50000, 1) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(51000, 2) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(150000, 2) == false, "passed", "failed", "return false");
        test(isEligibleForLoan(151000, 0) == true, "passed", "failed", "return true");
        test(isEligibleForLoan(51000, 2.5) == true, "passed", "failed", "return true");
        Computer myImac = new Computer();
        println(myImac);

        Computer myLenovo = new Computer("Lenovo X1", "1TB");
        println(myLenovo);

        Computer myWorkLenovo = new Computer("Lenovo X1", "1TB");

        test(myImac.equals(myLenovo) == false, "passed", "failed", "should return false");
        test(myWorkLenovo.equals(myLenovo) == true, "passed", "failed", "should return true");
    public static boolean isEligibleForLoan(double income, double numYearsAtCurrentWorkPlace) {
        if (income > 150000) return true;
        else if (income < 50000) return false;
        else return numYearsAtCurrentWorkPlace > 2;
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
