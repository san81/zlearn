
package com.san.learn.ll;

/**
 * Reversing a single linked list with out using extra node
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jan 12, 2015
 */
public class ReverseSLL {
    
    static class Node {
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        
        public Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
    }

    public static void main(String ar[]){
        Node tail = new Node(1);
        Node node2 = new Node(2,tail);
        Node node3 = new Node(3, node2);
        Node head = new Node(4, node3);
        System.out.println(" Single LL ");
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data+" -> ");
            temp=temp.next;
        }
        
        Node revershead=head;
        Node headNext=revershead.next;
        revershead.next=null;
        
        while(headNext!=null){
            temp=headNext.next;
            headNext.next=revershead;
            revershead=headNext;
            headNext=temp;
        }
        
        System.out.println(" After reversing Single LL ");
         temp = revershead;
        while(temp!=null){
            System.out.println(temp.data+" -> ");
            temp=temp.next;
        }
    }
}
