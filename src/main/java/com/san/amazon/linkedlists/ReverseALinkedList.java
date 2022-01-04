package com.san.amazon.linkedlists;

public class ReverseALinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode revHead = null;
        ListNode current = head;
        while(current!=null) {
            ListNode tmp = current.next;
            current.next = revHead;
            revHead = current;
            current = tmp;
        }
        return revHead;
    }
}
