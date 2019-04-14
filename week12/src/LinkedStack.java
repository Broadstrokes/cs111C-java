import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedStack<T> implements StackInterface<T> {

    private Node topNode; // References the first node in the chain

    public LinkedStack() {
        topNode = null;
    } // end default constructor

    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
//    topNode = new Node(newEntry, topNode); // Alternate code
    } // end push

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } // end peek

    public T pop() {
        T top = peek(); // Might throw EmptyStackException
        // Assertion: topNode != null
        topNode = topNode.getNextNode();

        return top;
    } // end pop

    public boolean isEmpty() {
        return topNode == null;
    } // end isEmpty

    public void clear() {
        topNode = null; // Causes deallocation of nodes in the chain
    } // end clear

    public T peekNext() {
        if (isEmpty()) throw new EmptyStackException();
        else if (topNode.getNextNode() != null) return topNode.getNextNode().data;
        else return null;
    }

    public boolean priorityPush(T element) {
        if (!isEmpty()) {
            if (!this.peek().equals(element)) {
                Node previousNodeIfElementFound = this.contains(element);
                if (previousNodeIfElementFound == null) {
                    System.out.println("NOT FOUND IN LIST. PUSH REGULAR");
                    this.push(element);
                    return false;
                } else {
                    System.out.println("FOUND IN LIST. REMOVE & PUSH TO TOP");
                    Node nodeToRemove = previousNodeIfElementFound.getNextNode();
                    previousNodeIfElementFound.setNextNode(nodeToRemove.getNextNode());
                    this.push(element);
                    return true;
                }
            } else {
                System.out.println("FOUND IN LIST - TOP NODE - DO NOTHING");
                return true;
            }
        } else {
            System.out.println("LIST EMPTY. PUSH REGULAR");
            this.push(element);
            return false;
        }
    }

    private Node contains(T element) {
        Node currentNode = topNode;
        Node previousNode = null;
        while (currentNode != null) {
            if (currentNode.getData().equals(element)) {
                return previousNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        return null;
    }

    @Override
    public String toString() {
        String s = "";
        Node current = topNode;
        while (current != null) {
            s = current.data + " " + s;
            current = current.next;
        }
        return s;
    }

    private class Node {
        private T data; // Entry in stack
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
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

} // end LinkedStack