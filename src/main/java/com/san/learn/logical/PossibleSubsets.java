
package com.san.learn.logical;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubsets {
    
    public static void main(String ar[]){
        String s="abcde";
        List<String> allSubSets = getAllSubSets(s);
        //Add an empty set
        allSubSets.add("$");
        System.out.println(allSubSets.size()+" "+allSubSets);
    }
    
    public static List<String> getAllSubSets(String s){
        List<String> result = new ArrayList<String>();
        if(s.length()==0){
            result.add(" ");
        }
        else if(s.length()==1){
            result.add(s);
        }else{
            List<String> subsetsTillLastIndex = getAllSubSets(s.substring(0,s.length()-1));
            result.addAll(subsetsTillLastIndex);
            char charForThisCycle = s.charAt(s.length()-1);
            result.add(charForThisCycle+"");
            for(String ss:subsetsTillLastIndex){
                result.add(ss+charForThisCycle);
            }
        }
        return result;
    }

}
