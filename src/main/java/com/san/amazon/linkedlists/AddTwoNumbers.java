package com.san.amazon.linkedlists;



//Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  public String toString() {
      if(next!=null)
          return val+" -> " + next.toString();
      return val+"";
  }
}

class AddTwoNumbers {
    public ListNode addGivenLL(ListNode input, ListNode result, int carry) {
        while(input!=null){
            int sum = input.val + carry;
            if(sum >=10){
                carry = 1;
                sum -= 10;
            }else{
                carry = 0;
            }
            ListNode ln = new ListNode(sum);
            result.next = ln;
            result = ln;
            input = input.next;
        }
        if(carry!=0){
            ListNode ln = new ListNode(carry);
            result.next = ln;
            result = ln;
        }
        return result;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode result = root;
        int carry = 0;
        while(l1!=null && l2!=null) {
            int sum = l1.val + l2.val + carry;
            if(sum>=10){
                carry = 1;
                sum -= 10;
            }else {
                carry = 0;
            }
            ListNode ln = new ListNode(sum);
            result.next = ln;
            result = ln;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1==null && l2!=null){
            result = addGivenLL(l2, result, carry);
        }else if(l2==null && l1!=null){
            result = addGivenLL(l1, result, carry);
        }else {
            if(carry!=0){
                ListNode ln = new ListNode(carry);
                result.next = ln;
                result = ln;
            }
        }



        root = root.next;
        return root;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2= new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
