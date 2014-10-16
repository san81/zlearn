
package com.san.learn.concur;

public class StaticSyncVsNonStaticSync {

    public synchronized void show(String tname){
        System.out.println(" Synchronized Instance method "+tname);
    }
    
    public static synchronized void showStat(String tname){
        System.out.println(" Static show method "+tname);
    }
    
    public static void main(String ar[]){
        StaticSyncVsNonStaticSync obj1 = new StaticSyncVsNonStaticSync();
        T1 tOne = new T1(obj1,"T1");
        T1 tTwo = new T1(obj1,"T2");
        
        tOne.start();
        tTwo.start();
        tTwo.suspend();
        tTwo.resume();
        obj1.show("tOne");
    }
}

class T1 extends Thread {
    StaticSyncVsNonStaticSync obj;
    String name;
    public T1(StaticSyncVsNonStaticSync obj, String name){
        this.obj=obj;
        this.name=name;
    }
    public void run(){
        obj.show(name);
    }
}