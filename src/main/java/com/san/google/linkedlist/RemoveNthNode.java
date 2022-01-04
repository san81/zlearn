package com.san.google.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slowPt = dummyNode;
        ListNode fastPt = dummyNode;

        for(int i=0;i<=n;i++){
            fastPt = fastPt.next;
        }

        while(fastPt!=null) {
            slowPt = slowPt.next;
            fastPt = fastPt.next;
        }

        slowPt.next = slowPt.next.next;
        return dummyNode.next;
    }
}
