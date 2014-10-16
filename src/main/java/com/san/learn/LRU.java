
package com.san.learn;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    
    public Map<Integer, DoublyLinkedList> map = new HashMap<Integer, DoublyLinkedList>();
    public DoublyLinkedList head;
    public DoublyLinkedList tail;
    int capacity;
    int len;
    
    public LRU(int capacity){
        this.capacity=capacity;
        len=0;
    }
    
    public void setHead(DoublyLinkedList node){
        if(head==null){
            head=node;
            head.next=null;
            head.pre=null;
        }else{
            
           
            if(node.pre!=null && node.next!=null){
                node.pre.next=node.next;
                node.next.pre=node.pre;
                node.next=head;
                head.pre=node;
                head=node;
                head.pre=null;
            }else if(node.pre==null && node.next!=null){
                //this is already head node  do nothing.
                
            }else if(node.pre!=null && node.next==null){
                //this is tail.  move tail node to head
                tail=node.pre;
                node.pre.next=null;
                node.next=head;
                head.pre=node;
                head=node;
                head.pre=null;
            }else {
                //Adding new element
                node.next=head;
                head.pre=node;
                head=node;
            }
        }
    }
    
    public void removeKey(Integer key){
        DoublyLinkedList nodeToRemove=map.get(key);
        if(nodeToRemove!=null){
            if(nodeToRemove.pre==null){
                head=nodeToRemove.next;
                head.pre=null;
            }else if(nodeToRemove.next==null){
                tail=nodeToRemove.pre;
                nodeToRemove.pre.next=null;
            }else {
                nodeToRemove.pre.next=nodeToRemove.next;
                nodeToRemove.next.pre=nodeToRemove.pre;
            }
            map.remove(key);
        }
        
       
    }
    
    public void put(Integer key, String value){
        if(null==map.get(key)){
            DoublyLinkedList newNode=new DoublyLinkedList();
            newNode.value=value;
            map.put(key, newNode);
            if(len==capacity){
                tail.pre.next=null;
                tail=tail.pre;
            }
            
            setHead(newNode);
           
            len++;
        }else{
            DoublyLinkedList newHead=map.get(key);
            removeKey(key);
            setHead(newHead);
        }
    }
    
    public String get(Integer key){
        if(map.get(key)!=null){
            DoublyLinkedList latestNode=map.get(key);
            setHead(latestNode);
            return latestNode.value;
        }else{
            return null;
        }
    }
    
    public void print(){
        DoublyLinkedList startNode = head;
        String str="||";
        while(startNode!=null){
            str+=startNode.value+"->";
            startNode=startNode.next;
        }
         str+="||";
         System.out.println(str);
    }
    
    public static void main(String ar[]){
        LRU lru = new LRU(3);
        lru.put(1, "First");
        lru.print();
        lru.put(2, "Second");
        lru.print();
        System.out.println(lru.get(1));
        lru.print();
        System.out.println(lru.get(2));
        lru.print();
        lru.put(3, "Third");
        
        lru.print();
        System.out.println(lru.get(2));
        lru.print();
        lru.removeKey(1);
        lru.print();
        lru.put(1, "First");
        lru.put(4, "Four");
        lru.print();
        
    }

}

class DoublyLinkedList {
    String value;
    DoublyLinkedList pre;
    DoublyLinkedList next;
}