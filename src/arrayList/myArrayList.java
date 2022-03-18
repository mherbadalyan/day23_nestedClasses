package arrayList;

import java.util.Arrays;
import java.util.Iterator;

public class myArrayList<T> implements List<T>{
    private int size;
    private int capacity = 5;
    private Object[] data = new Object[capacity];

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
        for (int i = 0; i < size ; i++) {
            if (data[i].equals(element)){
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
        if (isDataFull()){
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
                 data[j] = data[j+1];
                }
                data[size -1] = null;
                size--;
            }
        }
        return false;
    }

    /**
     * getting element in given index
     */
    @Override
    public T get(int index) {
        isValidIndex(index);
        return (T) data[index];
    }

    /**
     * setting given element to given index of list and returning replaced element
     */
    @Override
    public T set(int index, T element) {
        T oldElement = (T)data[index];
        data[index] = element;
        return oldElement;
    }

    /**
     * adding element to given index of list
     */
    @Override
    public void add(int index, T element) {
        isValidIndex(index);
        if (isDataFull()){
            ensureCapacity();
        }
        for (int i = size; i > index ; i++) {
            data[i] = data[i - 1];
        }
        data[index] = element;
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
          return data[iteratorIndex] != null;
        }

        @Override
        public T next() {
            return (T) data[iteratorIndex++];
        }
    }

    //Not overrode helping methods

    /**
     * checking is given index valid
     * @param index
     */
    private void isValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checking is given list full. If it full ensuring capacity of list
     */
    private boolean isDataFull() {
        if (size == capacity) {
            capacity = size + size>>1;
            return true;
        }
        return false;
    }

    /**
     * creating new Array and copying elements from old array
     */
    private void ensureCapacity() {
        data = Arrays.copyOf(data,capacity);
    }
}
