import java.util.Objects;

public class Trio<T> {
    private T item1, item2, item3;


    /*
        CONSTRUCTORS
     */
    public Trio(T item1, T item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public Trio(T item) {
        this(item, item, item);
    }

    /*
        GETTERS & SETTERS
     */

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public T getItem2() {
        return item2;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    public T getItem3() {
        return item3;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }


    /*
        MEMBER METHODS
     */

    /**
     * Returns a count of how many times an item is in the Trio
     * @param target item to find
     * @return int count of how many times an item is in the Trio, if none return 0;
     */
    public int contains(T target) {
        int count = 0;

        if (item1.equals(target)) count++;
        if (item2.equals(target)) count++;
        if (item3.equals(target)) count++;

        return count;
    }

    /**
     * Returns true if the at least two items within the Trio are the same as each other
     * @return boolean true if there is a duplicate item, otherwise return false
     */
    public boolean hasDuplicates() {
        if (item1.equals(item2) || item1.equals(item3) || item2.equals(item3)) return true;
        return false;
    }

    /*
        OVERRIDES
     */

    @Override
    public String toString() {
        return "Trio {" +
                "item1 = " + item1 +
                ", item2 = " + item2 +
                ", item3 = " + item3 +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof  Trio<?>) {
            Trio<?> otherTrioR = (Trio<?>) other;

            if (item1.equals(otherTrioR.item1)) {
                if (item2.equals(otherTrioR.item2)) {
                    return item3.equals(otherTrioR.item3);
                } else if (item2.equals(otherTrioR.item3)) {
                    return item3.equals(otherTrioR.item2);
                } else {
                    return false;
                }
            } else if (item1.equals(otherTrioR.item2)) {
                if (item2.equals(otherTrioR.item1)) {
                    return item3.equals(otherTrioR.item3);
                } else if (item2.equals(otherTrioR.item3)) {
                    return item3.equals(otherTrioR.item1);
                } else {
                    return false;
                }
            } else if (item1.equals(otherTrioR.item3)) {
                if (item2.equals(otherTrioR.item2)) {
                    return item3.equals(otherTrioR.item1);
                } else if (item2.equals(otherTrioR.item1)) {
                    return item3.equals(otherTrioR.item2);
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

}

