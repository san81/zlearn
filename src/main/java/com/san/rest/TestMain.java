
package com.san.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

class  MyClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}



class SqdcChartSerializer implements JsonDeserializer<MyClass> {
    public JsonElement serialize(MyClass src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject chartJsonObj = new JsonObject();
        chartJsonObj.addProperty("name",src.getName()+" Hello!");
        return chartJsonObj;
    }

    @Override
    public MyClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        MyClass cla = new MyClass();
        cla.setName(json.getAsString()+"Name");
        return cla;
    }
}

public class TestMain {
    
    public static void main(String[] args) {
        /*GsonBuilder gb=new GsonBuilder();
        gb.registerTypeAdapter(MyClass.class, new SqdcChartSerializer());
        Gson gson=gb.create();
        MyClass obj = gson.fromJson("{\"name\": \"Sanjay\"}", MyClass.class);
        System.out.println(obj.getName());*/
        
        long  l = 10_000_000;
        System.out.println(l);
    }

    public static void main1(String[] args) throws IOException {
        FileInputStream fos = new FileInputStream(new File("/Users/santhoshgandhe/LeanTaas/apache-tomcat-7.0.29/temp/.druid/"));
        byte[] bytesRed = new byte[4096];
        int length=0;
        while((length=fos.read(bytesRed))>0){
            System.out.print(bytesRed);
        }
        fos.close();
    }

}
