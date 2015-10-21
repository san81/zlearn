
package com.san.learn.logical;

/**
 * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). 
 * And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
 * Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jan 13, 2015
 */
public class LargestSumContiguousSubArray {

    public static void main(String ar[]){
        int ary[] = new int[] { 3,-2,5,-4,2,7,-1 };
        int sumEndingHere=0, sumSoFar=0;
        int endIndex=0;
        int length=0;
        int incrCnt=0;
        int sumSoFarTillLstIteration=0;
        for(int i=0;i<ary.length;i++){
            sumSoFarTillLstIteration=sumSoFar;
            sumSoFar=sumSoFar+ary[i];
            if(sumSoFar<0){
                sumSoFar=0;
                incrCnt=0;
                length=0;
            }
            
            if(sumSoFar>sumEndingHere){
                sumEndingHere=sumSoFar;
                endIndex=i;
                length+=incrCnt;
                incrCnt=0;
            }
            if( sumEndingHere>=sumSoFar && sumSoFar>sumSoFarTillLstIteration) {
                incrCnt++;
            }
           
            System.out.println(" SumEndingHere :: "+sumEndingHere+" sumTillNow "+sumSoFar+" Length: "+length);
        }
        System.out.println(" LargestSumContiguousSubArray :: "+sumEndingHere);
        System.out.println(" length :: "+length+" End Index "+endIndex);
    }
}
