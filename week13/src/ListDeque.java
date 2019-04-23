import java.util.LinkedList;
import java.util.List;

public class ListDeque<T> implements DequeInterface<T> {
    private List<T> list;

    public ListDeque() {
        this.list = new LinkedList<>();
    }

    @Override
    public void addToFront(T newEntry) {

    }

    @Override
    public void addToBack(T newEntry) {

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
    public T getFront() {
        return null;
    }

    @Override
    public T getBack() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
