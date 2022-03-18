package arrayList;

public class Main {
    public static void main(String[] args) {
    List<Integer> myArrayList = new myArrayList<Integer>();
    myArrayList.add(10);
    myArrayList.add(20);
    myArrayList.add(30);
    myArrayList.add(40);

        System.out.println("MyArrayList = " + myArrayList);
        System.out.println("Size of list = " + myArrayList.size());
        System.out.println("Third element of list = " + myArrayList.get(3));
        System.out.println("List is empty : " + myArrayList.isEmpty());
        System.out.println("List contains 50 : " + myArrayList.contains(50));
        System.out.println("Removing element with value 50 from list");
        myArrayList.remove(30);
        System.out.println("Setting in index 1 element with value 50");
        myArrayList.set(1,50);

        System.out.print("MyArrayList = ");
        for (Integer integer : myArrayList) {
            System.out.print(integer + " ");
        }
    }
}
