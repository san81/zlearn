package com.san;

/**
 * Created by santhoshgandhe on 6/20/18.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import net.spy.memcached.MemcachedClient;
public class MemcachedJava {
    public static void main(String[] args) {

        // Connecting to Memcached server on localhost
        MemcachedClient mcc = null;
        try {
            mcc = new MemcachedClient(new
                    InetSocketAddress("127.0.0.1", 11211));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Connection to server sucessfully");

        //not set data into memcached server
        try {
            System.out.println("set status:"+mcc.set("tutorialspoint", 900, "memcached").get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Get value from cache
        System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
    }
}