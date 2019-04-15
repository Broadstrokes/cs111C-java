public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {
    public Node firstNode;
    public Node lastNode;
    private int numberOfEntries;

    public LinkedHeadTailList() {
        initializeDataFields();
    }

    /**
     * Compare two lists based on the following criteria
     *     • compare the lists element-by-element
     *     • the first time you find an element that doesn't match, compare the lists based on that element
     *         - the list comparison is now done
     *     • if you do not find any mismatched elements and reach the end of one or both lists,
     *         - compare based on size (shorter list is smaller)
     *
     * @param otherList the other list to compare
     * @return  return 0 if both lists are same, a positive number if 1st
     *          mismatched element in the otherList is less than this list or other list is shorter,
     *          a -ive number if 1st mismatched element in the otherList other list is greater
     *          than this list or the other list is longer
     */
    @Override
    public int compareTo(LinkedHeadTailList<T> otherList) {
        Node nodeListA = firstNode;
        Node nodeListB = otherList.firstNode;

        while (nodeListA != null && nodeListB != null) {
            if (nodeListA.getData().compareTo(nodeListB.getData()) != 0) {
                return nodeListA.getData().compareTo(nodeListB.getData());
            }
            nodeListA = nodeListA.getNextNode();
            nodeListB = nodeListB.getNextNode();
        }

        return Integer.compare(this.numberOfEntries, otherList.numberOfEntries);
    }

    @Override
    public void addFront(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            lastNode = newNode;
        } else {
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
        } else { // Add to end of nonempty list
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
            if (numberOfEntries == 1) { // only 1 item in list
                lastNode = newFirst;
            }
            numberOfEntries--;
            firstNode = newFirst;
            return entryToReturn;
        } else { // list has no items
            return null;
        } // end if
    }

    @Override
    public T removeBack() {
        Node currentNode = firstNode;
        Node previousNode = null;
        T entryToReturn = null;
        if (!isEmpty()) {
            if (numberOfEntries == 1) { // only 1 item in list
                entryToReturn = currentNode.getData();
                initializeDataFields();
                return entryToReturn;
            } else { // list has more than 1 items
                while (currentNode != null && currentNode.getNextNode() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getNextNode();
                }
                previousNode.next = null;
                lastNode = previousNode;
                numberOfEntries--;
                return currentNode.getData();
            }
        } else { // list has no items
            return entryToReturn;
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
