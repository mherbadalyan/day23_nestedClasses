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
        isValidIndex(index);
        if (index == size - 1) {
            return last.val;
        } else {
            Node tempNode = first;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    break;
                } else {
                    tempNode = tempNode.next;
                }
            }
            return tempNode.val;
        }
    }

    /**
     * adding new Node at the end of the LinkedList.
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
     * add new Node at the given index of the LinkedList.
     */
    @Override
    public void add(int index, int val) {
        isValidIndexForAdd(index);
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
            if (i != index - 1) {
                tempNode = tempNode.next;
            } else {
                node.next = tempNode.next;
                tempNode.next = node;
            }
        }
        size++;
    }

    /**
     * deleting Node at given index.
     * */
    @Override
    public void delete(int index) {
        isValidIndex(index);
        if (index == 0) {
            first = first.next;
        } else {
            Node tempNode = first;
            for (int i = 1; i <= index; i++) {
                if (index == i) {
                    tempNode.next = tempNode.next.next;
                } else {
                    tempNode = tempNode.next;
                }
            }
        }
        size--;
    }


    // LinkedList not override helping private methods

    /**
     * adding first element in empty linkedList
     */
    private void addFirstElement(Node node) {
        first = node;
        last = node;
        size++;
    }

    /**
     * adding given Node at end of LinkedList
     */
    private void addAtEnd(Node node) {
        last.next = node;
        last = node;
        size++;
    }

    /**
     * checking is given index valid for adding in that index
     */
    private void isValidIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checking is given index valid
     */
    private void isValidIndex(int index) {
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
}
