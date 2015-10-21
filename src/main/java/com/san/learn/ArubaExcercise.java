
package com.san.learn;

import java.util.Scanner;

//Two arrays of integers and we want to find numbers in the first array which are not in the second array.

public class ArubaExcercise {

public static void main(String[] ar)
 {


     int sizeOfFirstArray=0;
             Scanner scnr = new Scanner(System.in);
     System.out.println(" give me first Array size");
             sizeOfFirstArray=scnr.nextInt();
     int[] firstArray = new int[sizeOfFirstArray];
     System.out.println(" give me values for first Array");

     for(int i=0;i<sizeOfFirstArray;i++){
         firstArray[i]=scnr.nextInt();
     }
     
     //we should do the same for the second one
     int[] secondArray = new int[10];
     int[] resultArray = getMeNotInList(firstArray, secondArray);
     if(null==resultArray){
         System.out.println("");
         
     }else
     for(int i=0;i<resultArray.length;i++){
         System.out.println(resultArray[i]);
     }
     scnr.close();
 }
 
 /**
     @return
 **/
 public static int[] getMeNotInList(int[] firstArray, int[] secondArray){
         
   if(null==firstArray ){
        return null;
     }
   
   if(null==secondArray){
       return firstArray;
   }
   
     int[] returningArray = new int[firstArray.length];
     int counter=0;
     for(int i=0;i<firstArray.length;i++){
         boolean found=false;
         for(int j=0;j<secondArray.length;j++){
             if(firstArray[i]==secondArray[j]){
                 found=true;
                 break;
             }
         }
         if(!found){
             returningArray[counter++]=firstArray[i];
         }
     }
     return returningArray;
 }
}
