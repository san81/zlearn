package com.san.amazon;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2!=null) {
            return l2;
        }else if(l2==null && l1!=null){
            return l1;
        }
        ListNode l = new ListNode();
        ListNode startNode = l;
        while(l1 != null && l2 !=null ){
            if(l1.val<l2.val){
                l.next = l1;
                l = l1;
                l1 = l1.next;
            }else if(l2.val<l1.val){
                l.next = l2;
                l = l2;
                l2 = l2.next;
            } else {
                l.next = l1;
                l = l1;
                l1 = l1.next;
                l.next = l2;
                l = l2;
                l2 = l2.next;
            }
        }

        if(l1 ==null){
            l.next = l2;
        }else{
            l.next = l1;
        }
        return startNode.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode l = null;
        for(ListNode cl:lists){
            l = mergeTwoLists(l, cl);
        }
        return l;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));

//        l1 = new ListNode();
//        l2 = new ListNode();

        ListNode mergedList = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while(mergedList!=null) {
            System.out.println(mergedList.val+" => ");
            mergedList = mergedList.next;
        }
    }

}
