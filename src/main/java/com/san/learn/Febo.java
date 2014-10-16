
package com.san.learn;

public class Febo {
    
    public static void main_(String ar[]){
        int i=0,j=1, sum=0;
        System.out.println(i);
        System.out.println(j);
        while(i<100){
            sum=i+j;
            System.out.println(sum);
            i=j;
            j=sum;
        }
    }
    
    public static void main(String ar[]){
        int i=0,j=1,k=1, sum=0;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        while(i<100){
            sum=i+j+k;
            System.out.println(sum);
            i=j;
            j=k;
            k=sum;
        }
    }


}
