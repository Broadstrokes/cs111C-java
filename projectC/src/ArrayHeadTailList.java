public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {
    private T[] listArray;
    private int numberOfElements;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 10;
//    private static final int MAX_CAPACITY = 10000;

    public ArrayHeadTailList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayHeadTailList(int initialCapacity) {
    }

    /*
        OVERRIDES
     */

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
        for (int i = 0; i < listArray.length; i++) {
            T currItem = listArray[i];
            if (currItem.equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return this.numberOfElements == 0;
    }


    /*
        PRIVATE METHODS
     */

//    private void checkCapacity(int capacity) {
//        if (capacity > MAX_CAPACITY) {
//            throw new IllegalArgumentException("Tried to create an array that exceeds max capacity");
//        }
//    }
}
