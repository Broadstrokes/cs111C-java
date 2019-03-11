import java.text.NumberFormat;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HomeworkM8Driver {

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getPercentInstance();

		System.out.println("*********************Array Sortedness Tester");
		Integer[] array1 = {1, 2, 3, 3, 5};
		Integer[] array2 = {1, 2, 3, 4, 5, 5};
		Integer[] array3 = {10, 8, 5, 3, 1};
		Integer[] array4 = {12, 11, 9, 3, 2, 1};
		Integer[] array5 = {2, 8, 3, 9, 6};
		Integer[] array6 = {7, 1, 6, 8, 5, 2};
		String[] array7 = {"abc", "def", "ghi"};

		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortedness(array3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortedness(array4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortedness(array5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortedness(array6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array7)));

		System.out.println("\n*********************Node Sortedness Tester: Iterative");

		// this code uses the same values as the arrays above
		Node<Comparable> chain1 = new Node<Comparable>(1, new Node<Comparable>(2, new Node<Comparable>(3,
				new Node<Comparable>(3, new Node<Comparable>(5)))));
		Node<Comparable> chain2 = new Node<Comparable>(1, new Node<Comparable>(2, new Node<Comparable>(3,
				new Node<Comparable>(4, new Node<Comparable>(5, new Node<Comparable>(5))))));
		Node<Comparable> chain3 = new Node<Comparable>(10, new Node<Comparable>(8, new Node<Comparable>(5,
				new Node<Comparable>(3, new Node<Comparable>(1)))));
		Node<Comparable> chain4 = new Node<Comparable>(12, new Node<Comparable>(11, new Node<Comparable>(9,
				new Node<Comparable>(3, new Node<Comparable>(2, new Node<Comparable>(1))))));
		Node<Comparable> chain5 = new Node<Comparable>(2, new Node<Comparable>(8, new Node<Comparable>(3,
				new Node<Comparable>(9, new Node<Comparable>(6)))));
		Node<Comparable> chain6 = new Node<Comparable>(7, new Node<Comparable>(1, new Node<Comparable>(6,
				new Node<Comparable>(8, new Node<Comparable>(5, new Node<Comparable>(2))))));
		Node<Comparable> chain7 = new Node<Comparable>("abc",
				new Node<Comparable>("def", new Node<Comparable>("ghi")));

		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessIterative(chain3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessIterative(chain4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortednessIterative(chain5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortednessIterative(chain6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain7)));

		System.out.println("\n*********************Node Sortedness Tester: Recursive (Extra Credit Option)");
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessRecursive(chain3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessRecursive(chain4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortednessRecursive(chain5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortednessRecursive(chain6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain7)));

	}
	@SuppressWarnings("Duplicates")
	public static double sortedness(Comparable[] array) {
		double sortedPairs = 0.0;
		double totalPairs = 0.0;
		if (array.length > 0) {
			for(int i = 0; i < array.length - 1; i++) {
				Comparable curr = array[i];
				Comparable next = array[i+1];
				System.out.println(">>> curr " + curr + " | nxt: " + next);

				if (curr.compareTo(next) <= 0) {
					sortedPairs += 1;
				}

				totalPairs++;
			}
			return sortedPairs/totalPairs;
		}

		return 0;
	}
	@SuppressWarnings("Duplicates")
	public static double sortednessIterative(Node<Comparable> node) {
		double sortedPairs = 0.0;
		double totalPairs = 0.0;
		while(node.next != null) {
			System.out.println(">>> curr " + node.data + " | nxt: " + node.next.data);

			if (node.data.compareTo(node.next.data) <= 0) {
				sortedPairs += 1;
			}

			totalPairs++;
			node = node.next;
		}
		return sortedPairs/totalPairs;
	}

	public static double sortednessRecursive(Node<Comparable> node) {
		return sortednessRecursiveHelper(node, 0.0 , 0.0);
	}

	private static double sortednessRecursiveHelper(Node<Comparable> currNode, double sorted, double total) {
		if (currNode.next == null) {
			return sorted/total;
		} else if(currNode.data.compareTo(currNode.next.data) <= 0) {
			sorted += 1.0;
		}
		total += 1.0;

		return sortednessRecursiveHelper(currNode.next, sorted, total);
	}
}


/*
Write two methods to measure to sortedness of a dataset. The sortedness is the degree to which data is sorted, ranging from 0 to 100%.

There are different ways to measure the degree of sortedness. For the homework, compare neighbor elements. The degree of sortedness is the percentage of neighbor-matches that are in sorted order.
(This is often described using the term inversions, which is two elements such that the index of element1 is < the index of element2, but element1 is greater than element2.)

For our purposes, we are considering only ascending order (smallest to largest) as being sorted.

Example: [2, 2, 4, 6, 7] has a 100% sortedness factor- all neighbor pairs of numbers are sorted
Example: [2, 2, 6, 4, 7] has a 75% sortedness factor- the 6-4 neighbor pair is not sorted, but all other neighbor pairs (2-2, 2-6, and 4-7) are sorted
Example: [7, 6, 4, 2, 1] has a 0% sortedness factor- no neighbor pairs are sorted in ascending order.
See the homework driver for more examples and test cases.
 */