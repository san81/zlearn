
package com.san.learn.inheritance;

/*
 * Java instance variables cannot be overridden in a subclass. Java inheritance doesn't work that way.
 */

class Parent   {
     protected int i=30;
 }

public class Child extends Parent {

    protected int i=20;
    
    public static void main(String ar[]){
        Child c=new Child();
        ((Parent)c).i=40;
        System.out.println(c.i);
        System.out.println(((Parent)c).i);
    }
}




