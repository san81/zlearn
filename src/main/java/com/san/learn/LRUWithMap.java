/*
 *  Any use of the Material is governed by the terms of the actual license
 *  agreement between LeanTaaS Inc. and the user.
 *  Copyright 2010 LeanTaaS Inc., LOS GATOS CA USA.
 *  All rights reserved. Any rights not expressly granted herein are
 *  reserved.
 */
package com.san.learn;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUWithMap<K, V> {
    
    private int capacity;
    private Map<K, V> cache;
    
    public LRUWithMap(int maxCapacity) {
        this.capacity = maxCapacity;
        cache = Collections.synchronizedMap(new LinkedHashMap<K, V>(capacity, 0.75f, true) {

            /**
             * Comment for <code>serialVersionUID</code>
             */
            private static final long serialVersionUID = 1L;
            
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > capacity;
            }
        });
    }
    
    public void put(K key, V value) {
        cache.put(key, value);
    }
    
    public V get(K key) {
        return cache.get(key);
    }
    
    public V remove(K key) {
        return cache.remove(key);
    }
    
    public static void main(String ar[]){
        LRUWithMap<Integer, String> lru = new LRUWithMap<Integer, String>(3);
        lru.put(1, "First");
        System.out.println(lru.cache);
        lru.put(2, "Second");
        System.out.println(lru.cache);
        System.out.println("Get >>>>> 1 >>>>"+lru.get(1));
        System.out.println(lru.cache);
        System.out.println("Get >>>>> 2 >>>>"+lru.get(2));
        System.out.println(lru.cache);
        lru.put(3, "Third");
        
        System.out.println(lru.cache);
        System.out.println("Get >>>>> 2 >>>>"+lru.get(2));
        System.out.println(lru.cache);
        lru.remove(1);
        System.out.println(lru.cache);
        lru.put(1, "First");
        lru.put(4, "Four");
        System.out.println(lru.cache);
        
    }
}
