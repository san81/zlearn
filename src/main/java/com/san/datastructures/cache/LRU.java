
package com.san.datastructures.cache;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    
    public Map<Integer, DoublyLinkedList> map = new HashMap<Integer, DoublyLinkedList>();
    public DoublyLinkedList head;
    public DoublyLinkedList tail;
    int capacity;
    
    public LRU(int capacity){
        this.capacity=capacity;
    }
    
    public void setHead(DoublyLinkedList node){
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DoublyLinkedList node) {
        if(node.pre != null) {
            node.pre.next = node.next;
        }else {
            head = node.next;
        }

        if(node.next !=null) {
            node.next.pre = node.pre;
        }else {
            tail = node.pre;
        }
    }


    public void addToHead(DoublyLinkedList node) {
        node.pre = null;
        node.next = head;

        if(head !=null) {
            head.pre = node;
        }

        head = node;

        if(tail == null) {
            tail = node;
        }
    }

    public void removeKey(Integer key){

        DoublyLinkedList node = map.get(key);
        if(node == null) return;

        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            tail = node.pre;
        }

        node.pre = null;
        node.next = null;

        map.remove(key);
    }
    
    public void put(Integer key, String value) {
        DoublyLinkedList newHead=map.get(key);
        if(newHead != null) {
            newHead.value = value;
            setHead(newHead);
            return;
        }

        DoublyLinkedList newNode=new DoublyLinkedList();
        newNode.value=value;
        map.put(key, newNode);
        if(map.size()==capacity){
            removeNode(newNode);
        }
        setHead(newNode);
        setHead(newNode);
    }
    
    public String get(Integer key){
        DoublyLinkedList latestNode=map.get(key);
        if(latestNode==null) return null;
        setHead(latestNode);
        return latestNode.value;
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
        lru.put(1, "Fir");
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
    int key;
    String value;
    DoublyLinkedList pre;
    DoublyLinkedList next;
}