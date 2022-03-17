public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(0,50);
        list.delete(3);

        System.out.println("LinkedList = " + list);
        System.out.println("Number in index 1 = " + list.get(1) );
        System.out.println("List is empty : " + list.isEmpty());
        System.out.println("Size of list = " + list.size());

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
