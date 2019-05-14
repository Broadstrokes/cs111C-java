import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		BinaryNode<T> currentNode = getRootNode();
		while (currentNode != null) {
			int comparison = newEntry.compareTo(currentNode.getData());

			if (comparison <= 0) {
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				} else {
					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					break;
				}
			} else if (comparison > 0) {
				if (currentNode.hasRightChild()) {
					currentNode = currentNode.getRightChild();
				} else {
					currentNode.setRightChild(new BinaryNode<>(newEntry));
					break;
				}
			}
		}
	}


	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();

		// consider a loop!
		while (currentNode != null) {
			int comparison = target.compareTo(currentNode.getData());
			if (comparison == 0) { count++; }

			if (comparison <= 0) { // traverse left side
				currentNode = currentNode.getLeftChild();
			} else if (comparison > 0) { // traverse right side
				currentNode = currentNode.getRightChild();
			}
		}

		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		
		return countGreaterRecursiveHelper(target, rootNode, count);
	}

	private int countGreaterRecursiveHelper(T target, BinaryNode<T> node, int count) {
		int comparison = target.compareTo(node.getData());
//		if (target.equals(10))
//			System.out.println(">>>>>>>>>" + target.toString() + " " + node.getData());
			if (comparison < 0) count++;
			if (node.hasLeftChild()) {
				count = countGreaterRecursiveHelper(target, node.getLeftChild(), count);
			}
			if (node.hasRightChild()) {
				count = countGreaterRecursiveHelper(target, node.getRightChild(), count);
			}
		return count;
	}
		
	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE! 
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(currentNode);

		// consider a loop based on the stack!
		while (!nodeStack.empty()) {
			currentNode = nodeStack.pop();
			int comparison = target.compareTo(currentNode.getData());

			if (comparison < 0) count++;
			if (currentNode.hasLeftChild()) {
				nodeStack.push(currentNode.getLeftChild());
			}
			if (currentNode.hasRightChild()) {
				nodeStack.push(currentNode.getRightChild());
			}
		}
		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n). 
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE. 
	public int countUniqueValues() {
		return 0;
	}
	
	
	
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
	


}