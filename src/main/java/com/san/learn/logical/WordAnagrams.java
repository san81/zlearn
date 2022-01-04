
package com.san.learn.logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * given a large file with contents like
1.CAT
2.DOG
3.TAC
4.ACT
5.GOD
6.ODG

Re-arrange it such that every line has the index of all of its anagrams
Eg Output
1.CAT 1,3,4
2.DOG 2,5,6
3.TAC 1,3,4
4.ACT 1,3,4
5.GOD 2,5,6
6.ODG 2,5,6

ac
bb 

 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jan 12, 2015
 */
public class WordAnagrams {

    public static void main(String[] args) {
        String[] inputStrs = {"CAT","DOG","TAC","ACT","GOD","ODG"};
        Map<Integer,List<Integer>> wordAnagaramIndex = new HashMap<Integer,List<Integer>>();
        Integer hash;
        List<Integer> anList;
        for(int i=0;i<inputStrs.length;i++){
            hash=getHash(inputStrs[i]);
            anList=wordAnagaramIndex.computeIfAbsent(hash, k -> new ArrayList<Integer>());
            anList.add(i+1);
        }
        
        for(int i=0;i<inputStrs.length;i++){
            System.out.println(inputStrs[i]+" : "+wordAnagaramIndex.get(getHash(inputStrs[i])));
        }
        
    }
    
    private static Integer getHash(String str){
        int hash=0;
        for(int i=0;i<str.length();i++){
            hash+=str.charAt(i);
        }
        return hash;
    }

}
