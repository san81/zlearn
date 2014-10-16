
package com.san.learn;

public class SingleTonWithMutex {

    public static SingleTonWithMutex instance;
    public static Object mutex=new Object();
    
    private SingleTonWithMutex(){
        
    }
    
    public static SingleTonWithMutex getInstance(){
        if(null==instance){
            synchronized (mutex) {
                if(null==instance){
                    instance=new SingleTonWithMutex();
                }
            }
        }
        return instance;
    }
    
    public static void main(String ar[]){
        SingleTonWithMutex obj = new SingleTonWithMutex();
        System.out.println(obj);
    }
}
