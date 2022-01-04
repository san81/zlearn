package com.san.amazon.linkedlists;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    Node(int val, Node next) { this.val = val; this.next = next; }

    public String toString() {
        if(next!=null)
            return val+" -> " + next.toString();
        return val+"";
    }
}

public class CopyListWithRandomPointers {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node current = head;
        while(current!=null){
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }
        current = head;
        while(current!=null){
            if(null!=current.random)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        current = head;
        Node newHead = head.next;
        Node newCurrent = current.next;
        while(current.next.next!=null){
            current.next = current.next.next;
            newCurrent.next = current.next.next;
            current = current.next;
            newCurrent = newCurrent.next;
        }
        current.next = current.next.next;
        return newHead;
    }

    public static void main(String[] args) {
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);

        n7.next = n13; n7.random = null;
        n13.next = n11; n13.random = n7;
        n11.next = n10; n11.random = n1;
        n10.next = n1; n10.random = n11;
        n1.next = null; n1.random = n7;
        System.out.println(n7);
        System.out.println(new CopyListWithRandomPointers().copyRandomList(n7));
        System.out.println(n7);
    }
}

