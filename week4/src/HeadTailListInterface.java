/**
 An interface that describes the operations of a Queue Stack combo;
 allowing a user to remove from add to either the front or the back
 & taking a peek at any position in the list. The list is 0 indexed

 @author Dan Sajjad
 @version 1.0
 */
public interface HeadTailListInterface<T> {

    /**
     * Adds an entry to the front of the list.
     *
     * @param newEntry This object gets added to the front of the list.
     */
    public void addFront(T newEntry);

    /**
     * Adds an entry to the back of the list.
     *
     * @param newEntry This object gets added to the back of the list.
     */
    public void addBack(T newEntry);

    /**
     * Removes an entry from the front of the list.
     *
     * @return T The entry at the front of the list.
     */
    public T removeFront();

    /**
     * Removes an entry from the back of the list.
     *
     * @return T The entry at the back of the list.
     */
    public T removeBack();

    /**
     * Gets an entry at a given position from this list.
     * The list is 0 indexed.
     *
     * @param position An integer that indicates the position of the entry to get.
     * @return
     */
    public T getEntry(int position);

    /**
     * Prints the list.
     *
     */
    public void display();

    /**
     * Tests whether this list contains a given entry.
     *
     * @param entry The entry to find.
     * @return True if the bag contains the entry, or false if not.
     */
    public int contains (T entry);

    /**
     * Tests whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Gets the current number of entries in this list.
     *
     * @return The integer indicating the number of entries currently in the list.
     */
    public int size();

    /**
     * Removes all entries from this list.
     *
     */
    public void clear();

} // end HeadTailListInterface
