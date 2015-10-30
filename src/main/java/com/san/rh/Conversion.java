package com.san.rh;


/*
 * Must be able to handle any base-10 integer that is submitted as command line
 * argument, even negative numbers. Provide suitable error handling.
 */
public class Conversion {
    /**
     * Convert a base-10 integer to an 8-bit two's complement binary number, and
     * return the binary number.
     */
    public String base10to2(String base10) {
        Integer i = Integer.parseInt(base10);
        if(i>127 || i<-128){
            //exceeding the byte size limit;
        }
        Byte b = i.byteValue();
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    /**
     * Return 2's complement negative of the given base10 number and return the
     * binary number
     */
    public String negBase2(String base10) {
        Integer i = Integer.parseInt(base10);
        i=i*-1;
        return Integer.toBinaryString(i);
    }
    
    public static void main(String ar[]) {
        Conversion conv = new Conversion();
        System.out.println(conv.base10to2("-129"));
        System.out.println(conv.negBase2("-129"));
    }
}
