import java.util.*;

public class HomeworkM6Driver {
//
//	// I recommend changing these to smaller numbers to start with!
//	// Then once you think you have a good solution, you can increase them for more robust testing.
//	public static final int LIST_SIZE = 100;
//	public static final int SINGLE_DUPLICATE_NUMBERS = 10; // minimum number of numbers on the list that will appear twice (have a "single duplicate"
//	public static final int DOUBLE_DUPLICATE_NUMBERS = 5;  // minimum number of numbers on the list that will appear three times (have a "duplicate duplicate")
//
//
	public static void main(String[] args) {
//
//		// set up an Integer list that is guaranteed to have some single and double duplicates
//		List<Integer> numbers = new ArrayList<>();
//		Random generator = new Random();
//		int max = 5 * LIST_SIZE;
//		int min = -1 * max;
//		int randomRange = max - min + 1;
//
//		// add the first round of numbers
//		int originalNumbersToAdd = LIST_SIZE- SINGLE_DUPLICATE_NUMBERS - DOUBLE_DUPLICATE_NUMBERS;
//		numbers.add(min); // adding the min and max number to help test for array out of bounds errors
//		numbers.add(min);
//		numbers.add(max);
//		numbers.add(max);
//		numbers.add(0);  // adding 0 as a special test case
//		numbers.add(0);
//		originalNumbersToAdd-=6;
//		for(int i=0; i<originalNumbersToAdd; i++) {
//			numbers.add(generator.nextInt(randomRange) + min);
//		}
//
//		// add duplicate numbers
//		Collections.shuffle(numbers);
//		for(int i=0; i<SINGLE_DUPLICATE_NUMBERS; i++) {
//			numbers.add(numbers.get(i));
//		}
//		for(int i=0; i<DOUBLE_DUPLICATE_NUMBERS; i++) {
//			numbers.add(numbers.get(i));
//		}
//
//		// print the list sorted (might help with testing)
//		Collections.sort(numbers);
//		System.out.println("The original list:");
//		System.out.println(numbers);
//		Collections.shuffle(numbers);
//
//		// the results should be the same for both methods
//		System.out.println("\nThe duplicate lists from both methods- these should match!");
//		List<Integer> duplicateList = findDuplicatesBad(numbers);
//		Collections.sort(duplicateList);
//		System.out.println(duplicateList);
//
//
//		System.out.println(">>>>>>>>>>>>>>>>>>>>> ");
//		duplicateList = findDuplicatesLinear(numbers);
//		Collections.sort(duplicateList);
//		System.out.println(duplicateList);
//
//
//		System.out.println(">>>>>>>>>>>>>>>>>>>>> TEST 1");
//		test1();

		test2(5);
		test2(10);
		test2(15);
		test2(20);
		test2(100);

	}


	public static void test2(int n) {
		int j = 0;
		int sum=0;

		for(int counter = n; counter > 0; counter = counter-2) {
			System.out.println(j);
			j++;
			sum = sum + counter;
		}
		System.out.println("------------------------ " + n);
	}

	public static void test1() {
//		Integer[] intArray = new Integer[] {1, 1, 1, 2, 2, 3, 4, 5, 5, 5};

		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(1);
		input.add(1);
		input.add(2);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		input.add(5);
		input.add(5);

		System.out.println(findDuplicatesLinear(input));
	}


	public static List<Integer> findDuplicatesBad(List<Integer> numbers) {
		List<Integer> duplicateList = new ArrayList<Integer>();
		for(int i=0; i<numbers.size(); i++) {
			int numberEvaluating = numbers.get(i);
			boolean duplicateFound = false;
			
			for(int j=i+1; j<numbers.size() && !duplicateFound; j++) {
				int numberChecking = numbers.get(j);
				
				if(numberEvaluating==numberChecking && !duplicateList.contains(numberEvaluating)) {
					duplicateFound = true; 
					
					for(int k=j; k<numbers.size(); k++) {
						if(numberChecking==Integer.valueOf(numbers.get(k))) {
							duplicateList.add(numberChecking);
						}
					}
				}
			}
		}
		return duplicateList;
	}

	/**
	 *  [1, 1, 1, 2, 2, 3, 4, 5, 5, 5]
	 *	 [1, 1, 2, 5, 5]
	 * @param numbers
	 * @return
	 */
	
	public static List<Integer> findDuplicatesLinear(List<Integer> numbers) {
		List<Integer> duplicatesList = new ArrayList<Integer>(numbers.size());
		Set<Integer> seenItems = new HashSet<>();

		for (Integer item : numbers) { // O(n)
			if (seenItems.contains(item)) { // O(1) check
				duplicatesList.add(item); // O(1) - added to end & will not resize
			} else {
				seenItems.add(item); // O(1)
			}
		}
		return duplicatesList;
	}
}
