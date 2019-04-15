public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T> {
    public Node firstNode;
    public Node lastNode;
    private int numberOfEntries;

    public LinkedHeadTailList() {
        initializeDataFields();
    }


    @Override
    public void addFront(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            lastNode = newNode;
        } else { // Add to end of nonempty list
            newNode.setNextNode(firstNode);
        } // end if

        firstNode = newNode;
        numberOfEntries++;
    }

    @Override
    public void addBack(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        }
        else { // Add to end of nonempty list
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        } // end if

        numberOfEntries++;

    }

    @Override
    public T removeFront() {
        if (!isEmpty()) {
            T entryToReturn = firstNode.getData();
            Node newFirst = firstNode.getNextNode();
            if (numberOfEntries == 1) {
                lastNode = newFirst;
            }
            numberOfEntries--;
            firstNode = newFirst;
            return entryToReturn;
        }
        else { // Add to end of nonempty list
            return null;
        } // end if
    }

    @Override
    public T removeBack() {
        Node currentNode = firstNode;
        Node previousNode = null;
        while (currentNode != null && currentNode.getNextNode() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        if (previousNode != null) previousNode.next = null;
        if (currentNode != null) {
            numberOfEntries--;
            lastNode = previousNode;
            return currentNode.getData();
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        initializeDataFields();
    }

    @Override
    public T getEntry(int givenPosition) {
        T entryToReturn = null;
        Node currentNode = firstNode;
        int currentPosiiton = 0;
        while (currentNode != null) {
            if (currentPosiiton == givenPosition) {
                return currentNode.getData();
            } else {
                currentNode = currentNode.getNextNode();
                currentPosiiton++;
            }
        }

        return entryToReturn;
    }

    @Override
    /**
     * Displays the list
     * Sample output: [3, 4, 6, 2]	head=3	tail=2"
     */
    public void display() {
        String output = "[";
        Node currentNode = firstNode;

        while (currentNode != null) {
            output+= currentNode.getData();
            currentNode = currentNode.getNextNode();
            if(currentNode != null) {
                output += ", ";
            }
        }

        output += "]";

        if (firstNode != null && lastNode != null) {
            output += "\t";
            output += "head="+ firstNode.getData();
            output += "\t";
            output += "tail=" + lastNode.getData();
        }

        System.out.println(output);
    }

    @Override
    public int contains(T anEntry) {
        boolean found = false;
        int position = -1;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            position++;
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return found ? position : -1;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /*
        HELPER METHODS
     */

    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields


    /**
     * The Node class
     */
    private class Node {
        private T data; // Entry in list
        private Node next; // Link to next node

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
}
