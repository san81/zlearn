
package com.san.learn.recursive;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeopeCrossingBridge {

    public void solve(int[] source, int[] dest) {
        if (source.length==0) {
           // System.out.println(start + " -> " + end);
        } else {
            //pick two from source
            //pick one from dest
        }
    }

    public static void main(String[] args) {
        
        Set<Integer> source = new TreeSet<Integer>();
        Set<Integer> dest = new TreeSet<Integer>();
        int index=0;
        for(int i=1;i<100;i=i+2){
            source.add(i);
        }
        System.out.println(Arrays.toString(source.toArray()));
        PeopeCrossingBridge peopleCorssing = new PeopeCrossingBridge();
        //peopleCorssing.solve(source, dest);
    }
 }
