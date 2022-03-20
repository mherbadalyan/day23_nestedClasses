package arrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements List<T> {
    private int size;
    private int capacity = 5;
    private Object[] data;

    public MyArrayList() {
        this.data = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    /**
     * returning size of list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * retuning is list empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returning is given list contains given element
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * adding element to end of list
     */
    @Override
    public boolean add(T element) {
        if (isDataFull()) {
            ensureCapacity();
        }
        data[size] = element;
        size++;
        return true;
    }

    /**
     * removing given element from list
     */
    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[size - 1] = null;
                size--;
            }
        }
        return false;
    }

    /**
     * removing all elements from list
     */
    @Override
    public boolean removeAll() {
        data = new Object[capacity];
        size = 0;
        return true;
    }

    /**
     * getting element in given index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /**
     * setting given element to given index of list and returning replaced element
     */
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = (T) data[index];
        data[index] = element;
        return oldElement;
    }

    /**
     * adding element to given index of list
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (isDataFull()) {
            ensureCapacity();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < size; i++) {
            list.append(data[i]);
            list.append(" ");
        }
        return String.valueOf(list);
    }

    private class MyArrayListIterator implements Iterator<T> {

        int iteratorIndex;

        @Override
        public boolean hasNext() {
            return iteratorIndex != size;
        }

        @Override
        public T next() {
            return (T) data[iteratorIndex++];
        }
    }

    //Not overrode helping methods

    /**
     * checking is given index valid
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checking is given list full.
     */
    private boolean isDataFull() {
        return  (size == capacity);
    }

    /**
     * ensuring capacity , creating new Array and copying elements from old array
     */
    private void ensureCapacity() {
        capacity = size + (size >> 1);
        data = Arrays.copyOf(data, capacity);
    }
}
