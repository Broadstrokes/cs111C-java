import java.util.Arrays;

public class HomeworkM5Driver {

	public static void main(String[] args) {

		System.out.println("******TESTING QUESTION: COUNT DIVISIBLE");
		Node<Integer> firstNode = new Node<Integer>(Integer.valueOf(3),
				new Node<Integer>(Integer.valueOf(8),
						new Node<Integer>(Integer.valueOf(6),
								new Node<Integer>(Integer.valueOf(12)))));
		// sets up the chain 3 -> 8 -> 6 -> 12
		System.out.println("Result is 3: " + countDivisibleBy(firstNode, 3));

		firstNode = new Node<Integer>(Integer.valueOf(2),
				new Node<Integer>(Integer.valueOf(8),
						new Node<Integer>(Integer.valueOf(10),
								new Node<Integer>(Integer.valueOf(4)))));
		// sets up the chain 2 -> 8 -> 10 -> 4
		System.out.println("Result is 0: " + countDivisibleBy(firstNode, 3));
		
		firstNode = null; // represents an empty chain
		System.out.println("Result is 0 (without a crash): " + countDivisibleBy(firstNode, 3));

		firstNode = new Node<Integer>(Integer.valueOf(3)); // singleton chain
		System.out.println("Result is 1: " + countDivisibleBy(firstNode, 3));
		
		System.out.println("\n******TESTING QUESTION: PRINT EVERY OTHER");
		firstNode = new Node<Integer>(Integer.valueOf(3),
				new Node<Integer>(Integer.valueOf(8),
						new Node<Integer>(Integer.valueOf(6),
								new Node<Integer>(Integer.valueOf(12)))));
		// sets up the chain 3 -> 8 -> 6 -> 12
		System.out.println("Should print 3 6");
		printEveryOther(firstNode);
		
		firstNode = new Node<Integer>(Integer.valueOf(3),
				new Node<Integer>(Integer.valueOf(8),
								new Node<Integer>(Integer.valueOf(12))));
		// sets up the chain 3 -> 8 -> 12
		System.out.println("Should print 3 12");
		printEveryOther(firstNode);	
		
		firstNode = null;
		System.out.println("Should print nothing (but not crash)");
		printEveryOther(firstNode);

		firstNode = new Node<Integer>(Integer.valueOf(3));
		System.out.println("Should print 3");
		printEveryOther(firstNode);
		
		System.out.println("\n******TESTING QUESTION: LinkedBag GET MAX");
		LinkedBag<Integer> numbersBag = new LinkedBag<Integer>();
		numbersBag.add(1);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		System.out.println("The max in the bag is 4: " + numbersBag.getMax());
		numbersBag.add(4);
		System.out.println("The max in the bag is 4: " + numbersBag.getMax());
		numbersBag.add(5);
		System.out.println("The max in the bag is 5: " + numbersBag.getMax());
		numbersBag.clear();
		System.out.println("Should either print null or throw an exception- but NOT a Null Pointer Exception");
		System.out.println(numbersBag.getMax());
		numbersBag.add(1);
		numbersBag.add(3);
		numbersBag.add(3);
		numbersBag.add(6);
		System.out.println("The max in the bag is 6: " + numbersBag.getMax());
		System.out.println("The bag still holds 4: " + numbersBag.getCurrentSize());

		System.out.println("\n******TESTING QUESTION: LList ADD ALL");
		LList<String> produceList = new LList<String>();
		produceList.addAll(new String[]{"peach"});
		System.out.println("The list contains[peach] \n\t\t " + Arrays.toString(produceList.toArray()));
		String[] stringArray = { "banana", "date", "grape", "eggplant",	"jicama", "grape" };
		produceList.addAll(stringArray);
		System.out.println("The list contains[peach, banana, date, grape, eggplant, jicama, grape] \n\t\t "
						+ Arrays.toString(produceList.toArray()));
		System.out.println("Size is 7: " + produceList.getLength());
		
		System.out.println("\n******TESTING QUESTION: LList REMOVE ALL");
		LList<Integer> numberList = new LList<Integer>();
		System.out.println("Before removing 1, the list contains " + Arrays.toString(numberList.toArray()));
		numberList.removeAll(1);
		System.out.println("After, the list contains[]  \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 0: " + numberList.getLength());
		numberList.add(1);
		System.out.println("Before removing 1, the list contains " + Arrays.toString(numberList.toArray()) );
		numberList.removeAll(1);
		System.out.println("After, the list contains[]  \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 0: " + numberList.getLength());		
		numberList.add(1);
		numberList.add(1);
		numberList.add(1);
		System.out.println("Before removing 1, the list contains " + Arrays.toString(numberList.toArray()) +  "\tSize is 3: " + numberList.getLength());
		numberList.removeAll(1);
		System.out.println("After, the list contains[]  \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 0: " + numberList.getLength());		
		numberList.add(1);
		numberList.add(1);
		numberList.add(2);
		numberList.add(4);
		numberList.add(1);
		numberList.add(5);
		numberList.add(1);
		System.out.println("Before removing 1, the list contains " + Arrays.toString(numberList.toArray()) );
		numberList.removeAll(1);
		System.out.println("After, the list contains[2, 4, 5] \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 3: " + numberList.getLength());		
		numberList.clear();
		numberList.add(1);
		numberList.add(1);
		numberList.add(3);
		numberList.add(1);
		numberList.add(1);
		numberList.add(4);
		numberList.add(1);
		numberList.add(5);
		numberList.add(1);
		numberList.add(1);
		System.out.println("Before removing 1, the list contains " + Arrays.toString(numberList.toArray()));
		numberList.removeAll(1);
		System.out.println("After, the list contains[3, 4, 5] \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 3: " + numberList.getLength());		
		System.out.println("Before removing 5, the list contains " + Arrays.toString(numberList.toArray()) );
		numberList.removeAll(5);
		System.out.println("After, the list contains[3, 4] \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 2: " + numberList.getLength());	
		numberList.add(2, 4);
		numberList.add(5);
		System.out.println("Before removing 4, the list contains " + Arrays.toString(numberList.toArray()) );
		numberList.removeAll(4);
		System.out.println("After, the list contains[3, 5] \n\t\t\t" + Arrays.toString(numberList.toArray()) +  "\tSize is 2: " + numberList.getLength());	

		System.out.println("\n******TESTING QUESTION EXTRA CREDIT: DOUBLE NODE PALINDROME");
		DoubleNode<Integer> n3 = new DoubleNode<Integer>(4);
		DoubleNode<Integer> n2 = new DoubleNode<Integer>(3);		
		DoubleNode<Integer> n1 = new DoubleNode<Integer>(4);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.previous = n2;
		// sets up the chain 4->3-> 4
		System.out.println("Should print true: " + isPalindromeDoublyLinkedList(n1, n3));
		
		DoubleNode<Integer> n4 = new DoubleNode<Integer>(4);
		n3 = new DoubleNode<Integer>(3);
		n2 = new DoubleNode<Integer>(3);		
		n1 = new DoubleNode<Integer>(4);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		// sets up the chain 4->3->-3->4
		System.out.println("Should print true: " + isPalindromeDoublyLinkedList(n1, n4));

		n4 = new DoubleNode<Integer>(1);
		n3 = new DoubleNode<Integer>(2);
		n2 = new DoubleNode<Integer>(3);		
		n1 = new DoubleNode<Integer>(1);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		// sets up the chain 1->2->-3->1
		System.out.println("Should print false: " + isPalindromeDoublyLinkedList(n1, n4));
		
		n4 = new DoubleNode<Integer>(4);
		n3 = new DoubleNode<Integer>(3);
		n2 = new DoubleNode<Integer>(4);		
		n1 = new DoubleNode<Integer>(3);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		// sets up the chain 4->3->-4->3
		System.out.println("Should print false: " + isPalindromeDoublyLinkedList(n1, n4));

		n1 = new DoubleNode<Integer>(3);
		// sets up the chain 3
		System.out.println("Should print true: " + isPalindromeDoublyLinkedList(n1, n1));
		
		n1 = null;
		System.out.println("Should print true and not crash: " + isPalindromeDoublyLinkedList(n1, n1));
	}
	

	public static void printEveryOther(Node firstNode) {
		// YOUR CODE HERE
	}

	public static int countDivisibleBy(Node<Integer> firstNode, int divisor) {
		// YOUR CODE HERE
		return 0;
	
	}

	public static boolean isPalindromeDoublyLinkedList(DoubleNode<Integer> firstNode, DoubleNode<Integer> lastNode)  {
		// YOUR EXTRA CREDIT CODE HERE
		return false;
	}

}
