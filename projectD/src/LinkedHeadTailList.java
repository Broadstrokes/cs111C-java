public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T> {
    public Node firstNode;
    public Node lastNode;


    @Override
    public void addFront(T newEntry) {

    }

    @Override
    public void addBack(T newEntry) {

    }

    @Override
    public T removeFront() {
        return null;
    }

    @Override
    public T removeBack() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public void display() {

    }

    @Override
    public int contains(T anEntry) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


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
