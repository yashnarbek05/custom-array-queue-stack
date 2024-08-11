package linkedlist;

public class MyLinkedList {

    private Node head;
    private Node tail;

    //ADD O(n) O(n)
    public void add(int num) {
        Node node = new Node(num);
        if (isEmpty()) {
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void removeFirst() {
        if (isEmpty())
            return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        if (isEmpty())
            return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node cur = head;
        while (cur != tail) {
            if (cur.next == tail) {
                cur.next = null;
                tail = cur;
                return;
            }

            cur = cur.next;
        }
    }

    public void remove(int num) {
        if (isEmpty())
            return;

        if (head.val == num) {
            removeFirst();
            return;
        }
        if (tail.val == num) {
            removeLast();
        }

        Node cur = head;
        //1. first remove
        //2. last remove
        //3. other remove

        boolean deleted = false;
        while (cur != null) {
            if (cur.next != null && cur.next.val == num) {
                cur.next = cur.next.next;
                deleted = true;
                break;
            }
            cur = cur.next;
        }
        System.out.println(deleted);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getLastN(int n) {
        if (n < 1)
            throw new IllegalArgumentException("0 dan katta ber");

        Node first = head;
        Node second = head;

        for (int i = 1; i < n; i++) {
            second = second.next;

            if (second == null)
                throw new IllegalArgumentException("Katta son berding");
        }

        while (second != tail) {
            first = first.next;
            second = second.next;
        }

        return first.val;
    }

    public void printMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == tail) {
            System.out.println(slow.val);
        } else {
            System.out.println(slow.val + "/" + slow.next.val);
        }

    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");

        Node cur = head;
        while (cur != tail){
            res.append(cur.val).append(", ");
            cur = cur.next;
        }
        res.append(tail.val).append("]");
        return res.toString();
    }

    private static class Node {
        private final int val;

        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
