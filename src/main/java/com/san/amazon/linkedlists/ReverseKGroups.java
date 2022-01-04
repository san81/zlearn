package com.san.amazon.linkedlists;



//Definition for singly-linked list.

class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k)  {
        ListNode rev = null;
        ListNode revHeadRoot = null;
        ListNode nextNode = head;
        ListNode nextCounter = head;
        while(nextNode!=null) {
            int counter = 0;
            while(counter<k && nextCounter!=null){
                nextCounter = nextCounter.next;
                counter++;
            }
            if(counter<k){

                if(revHeadRoot==null) {
                    revHeadRoot = nextNode;
                }else{
                    rev.next = nextNode;
                }
                nextNode = null;

            }else{
                ListNode revHead = null;
                while(counter>0){
                    ListNode tmpNode = nextNode.next;
                    nextNode.next = revHead;
                    revHead = nextNode;
                    nextNode = tmpNode;
                    counter--;
                }
                if(revHeadRoot==null) {
                    revHeadRoot = revHead;
                    rev = revHead;
                }else{
                    rev.next = revHead;
                }
                while(rev.next!=null) rev = rev.next;
            }

        }
        return revHeadRoot;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode l2= new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        System.out.println(new ReverseKGroups().reverseKGroup(l1, 2));
    }
}
