package arrayList;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    boolean contains(T element);

    boolean add(T element);

    boolean remove(T element);

    boolean removeAll();

    T get(int index);

    T set(int index, T element);

    void add(int index, T element);
}
