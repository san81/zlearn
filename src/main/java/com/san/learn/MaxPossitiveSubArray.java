
package com.san.learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

class MaxPosSubArray{
    ArrayList<Integer> subArray;
    Long sum=0l;
    int len=0;
    
    public MaxPosSubArray(ArrayList<Integer> subArray, long sum, int len){
        this.subArray=subArray;
        this.sum=sum;
        this.len=len;
    }
    
    public String toString(){
        return subArray.toString();
    }
}

public class MaxPossitiveSubArray {

    
      
    public static void main(String[] args) {
        int a[] = {   756898537, -1973594324, -2038664370, -184803526, 1424268980 };
        long sum=0;
        int len=0;
        TreeSet<MaxPosSubArray> maxSubArrays = new TreeSet<MaxPosSubArray>(new Comparator<MaxPosSubArray>() {

            @Override
            public int compare(MaxPosSubArray o1, MaxPosSubArray o2) {
                return o2.sum.compareTo(o1.sum);
            }
                
        });
        ArrayList<Integer> subArray=new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                //preserve the current sub array
                if(subArray.size()>0){
                    MaxPosSubArray maxPosSubArray= new MaxPosSubArray(subArray, sum, len);
                    maxSubArrays.add(maxPosSubArray);
                    subArray=new ArrayList<Integer>();
                    sum=0;
                    len=0;
                }
            }else{
                subArray.add(a[i]);
                sum+=a[i];
                len++;
            }
        }
        
        if(subArray.size()>0){
            MaxPosSubArray maxPosSubArray= new MaxPosSubArray(subArray, sum, len);
            maxSubArrays.add(maxPosSubArray);
            subArray=new ArrayList<Integer>();
            sum=0;
            len=0;
        }
        
        if(maxSubArrays.size()>0)
        System.out.println(maxSubArrays.first());
    }
    
}
