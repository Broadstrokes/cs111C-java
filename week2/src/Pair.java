
public class Pair<T> {
	
	private T item1, item2;
	
	public Pair(T item1, T item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public T getItem1() {
		return item1;
	}
	public T getItem2() {
		return item2;
	}
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public void setItem2(T item2) {
		this.item2 = item2;
	}
	
	@Override
	public String toString() {
		return item1.toString() + "\t" + item2.toString();
	}
	
	public boolean sameItems() {
		return item1.equals(item2);
		// return item1==item2; INCORRECT! tests for aliases, not logical equivalence
	}

	/**
	 * Two Pair objects are logically equivalent if their two objects are
	 * logically equivalent (ignoring order). For example, using this
	 * definition, the Pair (1,2)  would be equal to the Pair (2,1)
	 *
	 * @param other
	 * @return boolean if items are the same return true, else return false
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Pair<?>) {
			Pair<?> otherPairR = (Pair<?>) other;

			if (this.item1.equals(otherPairR.item1)) {
				return this.item2.equals(otherPairR.item2);
			} else if (this.item1.equals(otherPairR.item2)) {
				return this.item2.equals(otherPairR.item1);
			} else {
				return false;
			}
		}

		return false;
	}
}
