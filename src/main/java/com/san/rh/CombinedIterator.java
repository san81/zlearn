
package com.san.rh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CombinedIterator {

    public static List<String> combine(Iterator<String> itr1,Iterator<String> itr2) {
        List<String> combinedList = new ArrayList<String>();
        String itr1Str=null;
        String itr2Str=null;
        boolean pullFromFirst=true;
        boolean pullFromSecond=true;
      
        while(true) {
            if(pullFromFirst) {
                if(itr1.hasNext()) {
                    itr1Str = itr1.next();
                    pullFromFirst=false;
                }else{
                    break;
                }
                
            }
            if(pullFromSecond){
                if(itr2.hasNext()) {
                    itr2Str = itr2.next();
                    pullFromSecond=false;
                }else{
                    break;
                }
            }
            
            if(itr1Str.compareTo(itr2Str)<0){
                combinedList.add(itr1Str);
                pullFromFirst=true;
            }else if(itr1Str.compareTo(itr2Str)>0){
                combinedList.add(itr2Str);
                pullFromSecond=true;
            }else {
                combinedList.add(itr1Str);
                combinedList.add(itr2Str);
                pullFromSecond=true;
                pullFromFirst=true;
            }
        }
        
      
       if(pullFromFirst){
           if(null!=itr2Str){
               combinedList.add(itr2Str);
               pullFromFirst=false;
           }
       }
       
       if(pullFromSecond){
           if(null!=itr1Str) {
               combinedList.add(itr1Str);
               pullFromSecond=false;
           }
       }
        
       
            
            while(itr1.hasNext()){
                combinedList.add(itr1.next());
            }
       
        
       
            
            while(itr2.hasNext()){
                combinedList.add(itr2.next());
            }
       
        
        
        return combinedList;
    }
    
    public static void main(String ar[]) {
        Set<String> firstSet = new TreeSet<String>();
        Set<String> secondSet = new TreeSet<String>();
        firstSet.add("One");firstSet.add("Two");firstSet.add("Three");firstSet.add("Four");firstSet.add("Five");firstSet.add("Seven");
        secondSet.add("Six");secondSet.add("Eight");secondSet.add("Nine");secondSet.add("Ten");secondSet.add("Eleven");secondSet.add("Twelve");secondSet.add("Thirteen");
        System.out.println(firstSet);
        System.out.println(secondSet);
        System.out.println(combine(firstSet.iterator(), secondSet.iterator()));
        
    }
}
