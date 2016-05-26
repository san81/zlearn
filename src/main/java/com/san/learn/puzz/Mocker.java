
package com.san.learn.puzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mocker<T extends Exception> {

    private T t;
    
    
    public List<String> test = new ArrayList<String>(){ { add("test");  add("abcd"); }  };
    
    public List<String> testt = new ArrayList<String>(){ 
        {
            add("jhon");
            System.out.println(this);
        }
    };
    
    public Mocker(T t) {
            this.t = t;
    }
    private void pleaseThrow(final Exception e) throws T {
        throw (T) e;
    }    
    
    public T getMe(){
        return t;
    }
    
    public static void main(String ar[]){
        try{
            
           Mocker<RuntimeException> m= new Mocker<RuntimeException>(new RuntimeException());//.pleaseThrow(new SQLException());
           RuntimeException me = m.getMe();
           System.out.println(me.getClass().getName());
           
           Map<String,Object> collection = new TreeMap<>();
           /*System.out.println(collection.compute("foo",
                   (k,v) ->(v==null) ? new ArrayList<Object>() : ((List)v).add("bar"))
                   );
           */
        }catch(final RuntimeException e){
            e.printStackTrace();
        }catch(final Exception e){
            e.printStackTrace();
        }
    }
}

