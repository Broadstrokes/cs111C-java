import java.util.LinkedList;
import java.util.List;

public class ListDeque<T> implements DequeInterface<T> {
    private List<T> list;

    public ListDeque() {
        this.list = new LinkedList<>();
    }

    @Override
    public void addToFront(T newEntry) {
        list.add(0, newEntry);
    }

    @Override
    public void addToBack(T newEntry) {
        list.add(newEntry);
    }

    @Override
    public T removeFront() {
        if (!list.isEmpty()) {
            return list.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public T removeBack() {
        if (!list.isEmpty()) {
            return list.remove(list.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public T getFront() {
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T getBack() {
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return "ListDeque{" +
                "list=" + list +
                '}';
    }
}
