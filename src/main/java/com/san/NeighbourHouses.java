package com.san;

/**
 * Created by santhoshgandhe on 9/2/18.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class NeighbourHouses
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        for(int day=0;day<days;day++){
            int prevState = 0;
            for(int i=0;i<states.length;i++){
                int left = prevState;
                int right = 0;

                if((i+1)<states.length){
                    right=states[i+1];
                }

                //Store the previous value to use
                prevState = states[i];
                if((left==1 && right==1)||(left==0 && right==0)){
                    states[i]=0;
                }else{
                    states[i]=1;
                }
            }
        }
        List<Integer> list = new ArrayList<>(states.length);
        for(int val : states) {
            list.add(val);
        }
        return list;
    }


    // METHOD SIGNATURE ENDS


    public static void main(String ar[]){
        int[] states = new int[]{1,1,1,0,1,1,1,1};
        List<Integer> integers = cellCompete(states, 2);
        System.out.print(integers);
    }
}