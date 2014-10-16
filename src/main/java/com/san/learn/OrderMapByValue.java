
package com.san.learn;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class OrderMapByValue {

    public static void main(String ar[]){
        Map<Integer,String> myMap = new HashMap<Integer,String>();
        myMap.put(1,"first");
        myMap.put(2,"second");
        myMap.put(3,"third");
        myMap.put(4,"four");
        myMap.put(5,"five");
        myMap.put(null,"five");
        
       sort(myMap);
    }
    
    public static void sort(Map<Integer,String> myMap){
        TreeMap<Integer, String> sortedMap=new TreeMap<Integer, String>(new CustomComparator(myMap));
        for(Map.Entry<Integer, String> entry:myMap.entrySet()){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        for(Integer key:sortedMap.navigableKeySet()){
            System.out.println(sortedMap.get(key));
        }
    }
    
    
    public static void sortWithLL(Map<Integer,String> myMap){
        Set<Map.Entry<Integer, String>>  setToSort=myMap.entrySet();
        List<Map.Entry<Integer, String>> setToll = new LinkedList<Map.Entry<Integer, String>>(setToSort);
        Collections.sort(setToll,new Comparator<Map.Entry<Integer, String>>() {

            @Override
            public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        
        TreeMap<Integer, String> sortedMap=new TreeMap<Integer, String>(new CustomComparator(myMap));
        for(Map.Entry<Integer, String> entry:myMap.entrySet()){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        for(Integer key:sortedMap.navigableKeySet()){
            System.out.println(sortedMap.get(key));
        }
        
        for(Map.Entry<Integer, String> entry:sortedMap.entrySet()){
            
        }
    }
    
}

class CustomComparator implements Comparator<Integer> {

    Map<Integer,String> soureMap;
    public CustomComparator(Map<Integer,String> sourceMap){
        this.soureMap=sourceMap;
    }
   

    @Override
    public int compare(Integer o1, Integer o2) {
        return soureMap.get(o1).compareTo(soureMap.get(o2));
    }
    
}