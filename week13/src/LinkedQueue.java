/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode; // References node at front of queue
    private Node lastNode; // References node at back of queue

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);

        lastNode = newNode;
    } // end enqueue

    public T getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    } // end getFront

    public T dequeue() {
        T front = getFront(); // Might throw EmptyQueueException
        // Assertion: firstNode != null
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
            lastNode = null;

        return front;
    } // end dequeue

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty

    public void clear() {
        firstNode = null;
        lastNode = null;
    } // end clear

    public void display() {
        Node current = firstNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void splice(LinkedQueue<T> anotherQueue) {
        Node currentNode = anotherQueue.firstNode;
        while (currentNode != null) {
            this.enqueue(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

    private class Node {
        private T data; // Entry in queue
        private Node next; // Link to next node

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node linkPortion) {
            data = dataPortion;
            next = linkPortion;
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
} // end Linkedqueue

    