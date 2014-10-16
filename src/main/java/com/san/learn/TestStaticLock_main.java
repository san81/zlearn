
package com.san.learn;

 class TestStaticLock {

    public synchronized void m1(){
        System.out.println("this is m1");
    }
    
    public synchronized static void mStatic(){
        System.out.println("this is mStatic");
    }
}

 class Ttest extends Thread{
     TestStaticLock obj;
     public Ttest(TestStaticLock obj){
         this.obj=obj;
     }
     public void run(){
        try {
            synchronized (obj) {
                System.out.println("calling obj wait");
                obj. wait();
                System.out.println("out of wait state");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         obj.m1();
     }
 }
 
 class Ttest1 extends Thread{
     TestStaticLock obj;
     public Ttest1(TestStaticLock obj){
         this.obj=obj;
     }
     public void run(){
         synchronized (obj) {
             System.out.println("calling notify");
             obj.notify();
             System.out.println("after notify");
        }
         
         obj.mStatic();
     }
 }
public class TestStaticLock_main {
    public static void main(String ar[]){
        TestStaticLock obj= new TestStaticLock();
        Ttest test=new Ttest(obj);
        Ttest1 test1=new Ttest1(obj);
        test.start();
        test1.start();
    }

  
}
