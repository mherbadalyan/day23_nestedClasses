import arrayList.List;
import arrayList.MyArrayList;
import linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(3, 50);
        list.delete(3);

        System.out.println("LinkedList = " + list);
        System.out.println("Number in index 2 = " + list.get(2));
        System.out.println("LinkedList is empty : " + list.isEmpty());
        System.out.println("Size of list = " + list.size());

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("\n");


        List<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);

        System.out.println("MyArrayList = " + myArrayList);
        System.out.println("Size of list = " + myArrayList.size());
        System.out.println("Third element of list = " + myArrayList.get(3));
        System.out.println("List is empty : " + myArrayList.isEmpty());
        System.out.println("List contains 50 : " + myArrayList.contains(50));
        System.out.println("Removing element with value 30 from list");
        myArrayList.remove(30);
        System.out.println("Setting in index 1 element with value 50");
        myArrayList.set(1, 50);

        System.out.print("MyArrayList = ");
        for (Integer integer : myArrayList) {
            System.out.print(integer + " ");
        }
    }
}
