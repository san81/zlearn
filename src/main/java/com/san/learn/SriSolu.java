
package com.san.learn;

public class SriSolu {

    public static void main(String ar[]){
       
            int[] numbers=new int[]{ 1 , 3 , -2 , 0 , 4 , -2 , -1 , 8 } ;
            int noOfPositives = 22; // we can easily get this
            int noOfPositivesEncountered = 0;
            
            //int nextNum 
            for (int i = 0; i < numbers.length; i++) {
                
                if(noOfPositivesEncountered == noOfPositives){
                    break;
                }
                
                if(numbers[i] >= 0){
                    noOfPositivesEncountered++;
                    continue;
                }
                
                int nextNumBackup = numbers[i+1];
                
                for (int j = i; j < numbers.length; j++){
                    nextNumBackup = numbers[j+1];
                    
                    if(numbers[j+1] < 0){// swap nums and continue
                        numbers[j+1] = numbers[j];
                    }
                    else { // encountered a positive number, break
                        numbers[i] = numbers[nextNumBackup];
                        i = j+2;
                        break;
                    }
                }
                
          
            
        }
    }
}
