package hjtest.leecode.链表;

public class MyLinkedList {
    private final Node head;
    private int size;

    public MyLinkedList() {
        head = new Node(-1);
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node dummyHead = this.head;
        for (int i = 0; i <= index; i++) {
            dummyHead = dummyHead.next;
        }
        return dummyHead.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head.next;
        this.head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node dummyHead = this.head;
        for (int i = 0; i < size; i++) {
            dummyHead = dummyHead.next;
        }
        dummyHead.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node dummyHead = this.head;
        for (int i = 0; i < index; i++) {
            dummyHead = dummyHead.next;
        }
        Node node = new Node(val);
        node.next = dummyHead.next;
        dummyHead.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node dummyHead = this.head;
        for (int i = 0; i < index; i++) {
            dummyHead = dummyHead.next;
        }
        dummyHead.next = dummyHead.next.next;
        size--;
    }

    private static class Node {
        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
