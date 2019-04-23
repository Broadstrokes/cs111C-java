public class DequeStack<T> implements StackInterface<T> {
    private DequeInterface<T> deque;

    public DequeStack() {
        this.deque = new LinkedDeque<>();
    }

    @Override
    public void push(T newEntry) {
        deque.addToBack(newEntry);
    }

    @Override
    public T pop() {
        return deque.removeBack();
    }

    @Override
    public T peek() {
        return deque.getBack();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void clear() {
        deque.clear();
    }
}
