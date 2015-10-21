
package com.san.learn;

import java.util.Random;

//Finding the max value indexes and returning one of the random index of that index list

//int[] a; // size: 10000

//array[1, 3, 3, 1, 3] // Result should be either: 1,2 or 4, with equal chance


class FindMaxValueIndex { 

    // Runtime complexity: O(N);
    // Extra space complexity: O(N);
    public static int findMaxValueIndex(int a[]){
        //make sure it is not a empty array
        int maxValue=Integer.MIN_VALUE, maxValueIndex;
        for(int i=0;i<a.length;i++){
            if(maxValue<a[i]){
                maxValue=a[i];
                maxValueIndex=i;
            }
        }
        
        //find out all the indexes where this max value is present
        int[] maxValArray=new int[a.length];
        int j=0;
        for(int i=0;i<a.length;i++){
            if(maxValue==a[i]){
                maxValArray[j]=i;
                j++;
            }
        }
        int randomIndex=(int) ((Math.random()*100*j)/100);  //0 to 1  0.5=j/2    (0.5*100*5)/100=(300/100)=2
        // Random r = new Random(); r.nextInt(5);
        return maxValArray[randomIndex];
    }
    
    
    // Runtime complexity: O(N) - iterate only once over the array
    // Space complexity: O(1)
    //[1,2,2,2,3]   
    public static int findMaxValueIndexEfficient(int a[]){
        int maxValue=Integer.MIN_VALUE, maxValueIndex=0;
        int maxValueOccurencesCounter=0;
        Random r = new Random();
        for(int i=0;i<a.length;i++){
            if(maxValue<a[i]){
                maxValue=a[i];
                maxValueIndex=i;
                maxValueOccurencesCounter = 1;
            }else if(maxValue==a[i]){
                maxValueOccurencesCounter++;
                int whatToChoose=r.nextInt(maxValueOccurencesCounter);
                //whatToChoose will be one of the 0 to maxValueOccurencCout
                //The probability of making a switch depends on this matching whatToChoose to maxValueOccurence
                if(whatToChoose==maxValueOccurencesCounter-1){
                    maxValueIndex=i;
                }
            }
            
            // equals?
        }
        return maxValueIndex;
    }
    
}
