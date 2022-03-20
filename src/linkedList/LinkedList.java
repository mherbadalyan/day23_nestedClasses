package linkedList;

import java.util.Iterator;

public class LinkedList implements List {
    private int size = 0;
    private Node first;
    private Node last;

    private static class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private int index;

        private Node node = first;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Integer next() {
            Integer temp;
            index++;
            temp = node.val;
            node = node.next;
            return temp;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    /**
     * return size of the linked list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * return true if linked list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return value at given index.
     */
    @Override
    public int get(int index) {
        checkValidIndex(index);
        if (index == size - 1) {
            return last.val;
        }
        Node tempNode = first;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    break;
                }
                tempNode = tempNode.next;
            }
            return tempNode.val;
    }

    /**
     * adding new Node at the end of the linkedList.LinkedList.
     */
    @Override
    public void add(int val) {
        Node node = new Node(val);
        if (size == 0) {
            addFirstElement(node);
            return;
        }
        addAtEnd(node);
    }

    /**
     * add new Node at the given index of the linkedList.LinkedList.
     */
    @Override
    public void add(int index, int val) {
        checkValidIndexForAdd(index);
        Node node = new Node(val);
        if (size == 0) {
            addFirstElement(node);
            return;
        }
        if (index == size) {
            addAtEnd(node);
            return;
        }
        if (index == 0) {
            addFromStart(node);
            return;
        }
        Node tempNode = first;
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                node.next = tempNode.next;
                tempNode.next = node;
                break;
            }
            tempNode = tempNode.next;
        }
        size++;
    }

    /**
     * deleting Node at given index.
     */
    @Override
    public void delete(int index) {
        checkValidIndex(index);
        if (index == 0) {
            first = first.next;
        } else {
            Node tempNode = first;
            for (int i = 1; i <= index; i++) {
                if (index == i) {
                    if (tempNode.next == last) {
                        last = tempNode;
                    }
                    tempNode.next = tempNode.next.next;
                    break;
                }
                tempNode = tempNode.next;
            }
        }
        size--;
    }

    /**
     * returning given linkedList in String
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node node = first;
        for (int i = 0; i < size; i++) {
            list.append(node.val);
            list.append(" ");
            node = node.next;
        }
        return String.valueOf(list);
    }


    // linkedList.LinkedList not override helping private methods

    /**
     * adding first element in empty linkedList
     */
    private void addFirstElement(Node node) {
        first = node;
        last = node;
        size++;
    }

    /**
     * adding given Node at end of linkedList.LinkedList
     */
    private void addAtEnd(Node node) {
        last.next = node;
        last = node;
        size++;
    }

    /**
     * checking is given index valid for adding in that index
     */
    private void checkValidIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checking is given index valid
     */
    private void checkValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * adding given node in 0 index of linked list when it is not empty
     */
    private void addFromStart(Node node) {
        node.next = first;
        first = node;
        size++;
    }
}
