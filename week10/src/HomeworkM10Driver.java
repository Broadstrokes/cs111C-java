import java.util.*;

public class HomeworkM10Driver {

	public static void main(String[] args) {
		
		System.out.println("\n***TESTING CONTAINS METHOD");
		// NOTE: you might want to add additional print statements to make sure that your
		// method is "optimized" and takes advantage of the list being sorted!		
		SortedLinkedList<Integer> sortedNumList = new SortedLinkedList<Integer>();
		System.out.println("count of 99 is \t0: " + sortedNumList.countEntries(99));
		sortedNumList.add(4);
		sortedNumList.add(2);
		sortedNumList.add(3);
		sortedNumList.add(3);
		sortedNumList.add(1);
		sortedNumList.add(9);
		sortedNumList.add(3);
		sortedNumList.add(7);
		sortedNumList.add(4);
		sortedNumList.add(9);
		sortedNumList.add(1);
		sortedNumList.display();
		System.out.println("count of 1 is \t2: " + sortedNumList.countEntries(1));
		System.out.println("count of 2 is \t1: " + sortedNumList.countEntries(2));
		System.out.println("count of 3 is \t3: " + sortedNumList.countEntries(3));
		System.out.println("count of 4 is \t2: " + sortedNumList.countEntries(4));
		System.out.println("count of 7 is \t1: " + sortedNumList.countEntries(7));
		System.out.println("count of 9 is \t2: " + sortedNumList.countEntries(9));
		System.out.println("count of -1 is \t0: " + sortedNumList.countEntries(-1));
		System.out.println("count of 5 is \t0: " + sortedNumList.countEntries(5));
		System.out.println("count of 99 is \t0: " + sortedNumList.countEntries(99));
		sortedNumList.display();
		SortedLinkedList<String> sortedWordList = new SortedLinkedList<String>();
		sortedWordList.add("plum");
		sortedWordList.add("apple");
		sortedWordList.add("grapes");
		sortedWordList.add("banana");
		sortedWordList.add("tomato");
		sortedWordList.add("plum");
		sortedWordList.add("tomato");
		sortedWordList.add("pear");
		sortedWordList.display();
		System.out.println("count of apple is \t1: " + sortedWordList.countEntries(new String("apple")));
		System.out.println("count of tomato is \t2: " + sortedWordList.countEntries(new String("tomato")));
		System.out.println("count of carrot is \t0: " + sortedWordList.countEntries(new String("carrot")));
		sortedWordList.display();
		
		System.out.println("\n***TESTING BINARY SEARCH WTIH NULLS METHOD");
		String[] stringsWithBlanks1 = {"ant", null, null, "ball", null, null, null, "drive", null, null, "food"};
		for(int i=0; i<stringsWithBlanks1.length; i++) {
			if(stringsWithBlanks1[i]!=null) {
				String target = stringsWithBlanks1[i];
				System.out.println(target + " is at \t" + i + ": " + binarySearchWithNulls(stringsWithBlanks1, new String(target)));
			}
		}
		System.out.println("about is at \t-1: " + binarySearchWithNulls(stringsWithBlanks1, "about"));
		System.out.println("car is at \t-1: " + binarySearchWithNulls(stringsWithBlanks1, "car"));
		System.out.println("grove is at \t-1: " + binarySearchWithNulls(stringsWithBlanks1, "grove"));
		String[] stringsWithBlanks2 = {null, null, "mouse", null, null, "pumpkin", null, "yak", null, null, "zebra", null};
		for(int i=0; i<stringsWithBlanks2.length; i++) {
			if(stringsWithBlanks2[i]!=null) {
				String target = stringsWithBlanks2[i];
				System.out.println(target + " is at \t" + i + ": " + binarySearchWithNulls(stringsWithBlanks2, new String(target)));
			}
		}
		System.out.println("amount is at \t-1: " + binarySearchWithNulls(stringsWithBlanks2, "amount"));
		System.out.println("trunk is at \t-1: " + binarySearchWithNulls(stringsWithBlanks2, "trunk"));
		System.out.println("zed is at \t-1: " + binarySearchWithNulls(stringsWithBlanks2, "zed"));
		String[] stringsWithBlanks3 = {null, null, null, null, null};
		System.out.println("axel is at \t-1: " + binarySearchWithNulls(stringsWithBlanks3, "axel"));
		System.out.println("wild is at \t-1: " + binarySearchWithNulls(stringsWithBlanks3, "wild"));
		
	
		

	
		System.out.println("\n***EXTRA CREDIT: TESTING MERGE");
		SortedArrayList<Integer> listA = new SortedArrayList<Integer>();
		SortedArrayList<Integer> listB = new SortedArrayList<Integer>();
		System.out.println("List A and List B are empty.");
		SortedArrayList<Integer> mergedList = SortedArrayList.createMergeList(listA, listB);
		System.out.println("The merged list should also be empty: ");
		mergedList.display();

		System.out.println();
		listA.add(3);
		System.out.println("List A contains: 3");
		System.out.println("List B is empty.");
		mergedList = SortedArrayList.createMergeList(listA, listB);
		System.out.println("The merged list contains:\n3");
		mergedList.display();
		
		System.out.println();
		listA.clear();
		listB.add(4);
		System.out.println("List A is empty");
		System.out.println("List B contains: 4.");
		mergedList = SortedArrayList.createMergeList(listA, listB);
		System.out.println("The merged list contains:\n4");
		mergedList.display();
		
		System.out.println();
		listA.clear();
		listB.clear();
		listA.add(3);
		listA.add(1);
		listA.add(5);
		listB.add(4);
		listB.add(2);
		System.out.println("List A contains: 1 3 5");
		System.out.println("List B contains: 2 4");
		mergedList = SortedArrayList.createMergeList(listA, listB);
		System.out.println("The merged list contains:\n1 2 3 4 5");
		mergedList.display();
		
		System.out.println();
		listA.clear();
		listB.clear();
		listB.add(3);
		listB.add(1);
		listB.add(5);
		listA.add(4);
		listA.add(2);
		System.out.println("List A contains: 2 4");
		System.out.println("List B contains: 1 3 5");
		mergedList = SortedArrayList.createMergeList(listA, listB);
		System.out.println("The merged list contains:\n1 2 3 4 5");
		mergedList.display();
		
		System.out.println();
		listA.clear();
		listB.clear();
		listA.add(3);
		listA.add(2);
		listA.add(6);
		listA.add(9);
		listA.add(2);
		listA.add(7);
		listA.add(8);
		System.out.println("List A contains: 2 2 3 6 7 8 9");
		listB.add(3);
		listB.add(2);
		listB.add(4);
		listB.add(1);
		listB.add(6);
		listB.add(7);
		listB.add(5);
		listB.add(3);
		System.out.println("List B contains: 1 2 3 3 4 5 6 7");		
		mergedList = SortedArrayList.createMergeList(listA, listB);
		System.out.println("The merged list contains:\n1 2 2 2 3 3 3 4 5 6 6 7 7 8 9");
		mergedList.display();
		System.out.println("List A still contains:\n2 2 3 6 7 8 9");
		listA.display();
		System.out.println("List B still contains:\n1 2 3 3 4 5 6 7");
		listB.display();


	}
	public static int binarySearchWithNulls(String[] words, String target) {
		// YOUR CODE HERE
		return 0;
	}


}

