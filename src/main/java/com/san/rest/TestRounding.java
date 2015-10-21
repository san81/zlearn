
package com.san.rest;

public class TestRounding {

    public static void main(String[] args) {
        Double d = 165*100.0/426;
        
        System.out.println(Math.round(d*10)/10.0);
        
        d = 167*100.0/426;
        
        System.out.println(Math.round(d*10)/10.0);
    }

}
