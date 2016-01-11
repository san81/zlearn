
package com.san.learn.logical;

/**
 * Problem:
 * Given two arrays,  one is of size (n) and other one is of (n-1) having all these (n-1) elements present in the first array,
 * What is the best way to find the missing element in second array.
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Oct 17, 2014
 */
public class FindMissingInArray {

    public static void main(String ar[]){
        int firstAr[] = new int[]{1,2,3,4};
        int secondAr[] = new int[]{1,2,3};
        
        System.out.println(findMissing(firstAr, secondAr));
        System.out.println(findMissingLinear(firstAr,secondAr));
    }
    
    /**
     * Time complexity of this approach is O(n^2)
     * 
     * @param firstAr
     * @param secondAr
     * @return
     */
    public static int findMissing(int firstAr[], int secondAr[]){
        boolean found=false;
        for(int i=0;i<firstAr.length;i++){
            found=false;
            for(int j=0;i<secondAr.length;j++){
                if(firstAr[i]==secondAr[j]){
                    found=true;
                    break;
                }
            }
                if(!found){
                    return firstAr[i];
                
            }
        }
        return 0;
    }
    
    /**
     * Time complexity of this approach is O(n)
     * 
     * This approach is efficient and liner.
     * But this approach works only when
     * -there is only one element is missing
     * -and except the missing one, all other elements should present in both the arrays
     * 
     * @param firstAr
     * @param secondAr
     * @return
     */
    public static int findMissingLinear(int firstAr[], int secondAr[]){
        int firstSum=0;
        int secondSum=0;
        for(int i=0;i<firstAr.length;i++){
            firstSum+=firstAr[i];
        }
        
        for(int i=0;i<secondAr.length;i++){
            secondSum+=secondAr[i];
        }
        return firstSum-secondSum;
    }
}
