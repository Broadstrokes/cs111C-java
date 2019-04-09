import java.util.Objects;

public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashLocation(int voterID) {
		return voterID % tableSize;
	}

	public boolean addVoter(Voter voterToAdd) {
		int hashIndex = getHashLocation(voterToAdd.getId());
		Node<Voter> newNode = new Node<>(voterToAdd);

		if (hashTable[hashIndex] == null) {
			hashTable[hashIndex] = newNode;
		} else {
			Node<Voter> currentNode = hashTable[hashIndex];
			while (currentNode != null) {
				if (currentNode.getData().getId() == voterToAdd.getId()) {
					System.out.println(">>>>>>>>>>>>>>>>>> Voter already present");
					return false;
				} else if (currentNode.getNextNode() == null) {
					currentNode.next = newNode;
					return true;
				} else {
					currentNode = currentNode.getNextNode();
				}
			}
		}

		return true;
	}

	public Voter getVoter(int voterID) {
		int hashIndex = getHashLocation(voterID);
		if (hashTable[hashIndex] == null) {
			return null;
		} else {
			Node<Voter> currentNode = hashTable[hashIndex];
			while (currentNode != null) {
//				System.out.println("Looking for: " + voterID + " | Current Id: " + currentNode.getData().getId());
				if (currentNode.getData().getId() == voterID) {
					return currentNode.getData();
				}
				currentNode = currentNode.getNextNode();
			}
			System.out.println(">>>>>>>>>>>>>> Voter not found");
			return null;
		}
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print(i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
