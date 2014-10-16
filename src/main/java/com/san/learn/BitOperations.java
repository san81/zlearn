
package com.san.learn;

public class BitOperations {

    public static void main(String ar[]){
        long i=4,j=8;
        Double d=1.1;
       // System.out.println(~i+String.format(" %x",i)+String.format(" %x",~i));
       // System.out.printf("%02o\n", i);
        System.out.println(i+" = "+Long.toBinaryString(i));
        i=~i;
        System.out.println(i+" = "+Long.toBinaryString(i));
        System.out.println(i+" = "+Double.toHexString(d));
        System.out.println(i^j);
        System.out.println(i>>2);
        
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val );
        System.out.println(val & bitmask);
        
        
      
      
      
    }
}
