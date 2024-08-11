package linkedlist;


import java.util.Queue;

public class MainForLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.removeLast();
        System.out.println(list);

    }
}
