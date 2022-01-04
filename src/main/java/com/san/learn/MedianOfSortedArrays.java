package com.san.learn;

import java.util.*;

/*

Median of Two Sorted Arrays:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
 */

class MedianOfSortedArrays {

    public static float findMedian(int[] nums1, int[] nums2) {

        int totalCount = nums1.length + nums2.length;
        int medianIdx = totalCount/2 - 1;

//       if(totalCount % 2 == 0){
//         // even count so we need to sum up the middle numbers
//       }else{

//       }



        int nums1Idx = 0;
        int nums2Idx = 0;

        int counter = 0;

        boolean isFirstArray = true;
        int[] lastPickedFrom = null;
        int[] previousToLastPickedFrom = null;

        if(nums1[0] < nums2[0] ){
            lastPickedFrom = nums1;
        }else{
            lastPickedFrom = nums2;
        }


        while(nums1Idx < nums1.length && nums2Idx < nums2.length && counter < medianIdx) {
            previousToLastPickedFrom = lastPickedFrom;
            if(nums1[nums1Idx] < nums2[nums2Idx]){
                nums1Idx++;
                isFirstArray = true;
                lastPickedFrom = nums1;
            }else if(nums1[nums1Idx] > nums2[nums2Idx]) {
                nums2Idx++;
                isFirstArray = false;
                lastPickedFrom = nums2;
            } else {
                //both the values are same
                nums1Idx++;
                isFirstArray = true;
                lastPickedFrom = nums1;
            }
            counter++;
        }

        //if counter is still not catching up the median Idx
        if (counter < medianIdx ){

            if(nums1Idx < nums1.length) {

                if(totalCount % 2 == 0){
                    int idxToPick = nums1Idx + (medianIdx - counter);
                    return (nums1[idxToPick] + nums1[idxToPick-1] )/2.0f;
                }else{
                    return nums1[nums1Idx + (medianIdx - counter)];
                }


            } else {

                if(totalCount % 2 == 0){
                    int idxToPick = nums2Idx + (medianIdx - counter);
                    return (nums2[idxToPick] + nums2[idxToPick-1] )/2.0f;
                }else{
                    return nums2[nums2Idx + (medianIdx - counter)];
                }

            }
        }

        System.out.println(medianIdx);

        if(isFirstArray){

            if(totalCount % 2 == 0){
                int idxToPick = nums1Idx;

                return (previousToLastPickedFrom[idxToPick] + nums1[idxToPick+1] )/2.0f;
            }else{
                return nums1[nums1Idx];
            }

        }else{
            if(totalCount % 2 == 0) {
                int idxToPick = nums2Idx;
                return (previousToLastPickedFrom[idxToPick] + nums2[idxToPick+1] )/2.0f;
            }else{
                return nums2[nums2Idx];
            }
        }

    }

    public static void main(String[] args) {
        // int[] nums1 = new int[]{1, 1, 1, 3, 5, 7, 9};
        // int[] nums2 = new int[]{2, 4, 6};

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        // 1,1,1,2,3,4,5,6,7,9
        // (7+3)/2 = 5
        // medianIdx = 4

        float median = findMedian(nums1, nums2);
        System.out.println(median);

    }
}




//- Twitter feed
//        - adding the node
//
//        - Processing the billing for a specific seller M01 16 to 20 of this distribution
//        - How can we avoid the dedup. Duplicate charges. Realtime as well as the - identifying a unique payment
//
//




//
//interface Iterator {
//    next();
//    hasNext();
//    //remove();
//}
//
//
//- Linear collection
//        - Key values        -> keyset or valueSet or entryset
//
//class MyLLIterator implements Iterator {
//
//    private Collection<T> input;
//    int idx;
//    public MyLLIterator(Collection<T> input){
//        this.input = input;
//    }
//
//    public T next() {
//        if(hasnext()){
//            input.get(idx);
//            idx++;
//        }
//    }
//
//    public boolean hasNext() {
//        return idx < input.size();
//    }
//
//}
//
//    Set<Integer> somecollection = new HashSet();
//somecollection.get(i);
//
//        map.keyset().iterator()
//
//class HashMap {
//
//    class Entry {
//        String key;
//        String value;
//    }
//
//    hashvalue, List<Entry> entryList = new ArrayList<Entry>();
//
//    //hashvalue -> [ entry, entry ]
//
//
//    public put(String key, String value){
//        int hashvalue = hash(key);
//    }
//
//
//
//}
//
//
//class MyHashMapIterator implements Iterator {
//
//    private Map<K, V> input;
//    int idx;
//    public MyLLIterator(Map<K, V> input){
//        this.input = input;
//    }
//
//    public T next() {
//        if(hasnext()){
//            input.entrySet().get(idx);
//            idx++;
//        }
//    }
//
//    public boolean hasNext() {
//        return idx < input.entrySet().size();
//    }
//
//}
//
//
//
//
//
//
//
//1st String: ab
//        2nd String: cd
//        3rd String : abcd-->true
//        cdab-->true
//        cadb-->true
//        cbad-->false
//
//        ab ac
//        acab->true
//        aacb->true
//
//        acba-> false
//        |
//
//        [abc]
//
//        ab
//        ac
//        abac
//        bcaa
//
//        [
//        a ->[0, 0],
//        b ->[-1,1],
//        c ->[-1,1]
//        ]
//
//
//
//
//
//        firstString = ab
//        secondString = ac
//
//
//        abac
//
//        ab ac
//        |
//
//        abac'
//        |
//
//        tmpIdx1 = 0;
//        tmpIdx2 =1
//        |
//
//        int idx1 = 0;
//        int idx2 = 0;
//
//        charMap = new HashMap<Char, List<Integer>();
//
//        while(idx1<firstString.length){
//        List<integer> charIdxList= charMap.getOrDefault(firstString.charAt(i), new ArrayList<Integer>());
//        charIdxList.add(0,idx);
//        }
//
//        while(idx2<secondString.length){
//        List<integer> charIdxList= charMap.getOrDefault(secondString.charAt(i), new ArrayList<Integer>());
//        charIdxList.add(1,idx);
//        }
//
//        for(int i=0;i<thirdString.length; i++){
//        char cur = thirdString.charAt(i);
//
//        List charList = charMap.get(cur);
//        charList.
//
//        int tmpIdx1 = idx1;
//        int tmpIdx2 = idx2;
//
//        while(tmpIdx1 < firstString.length && firstString.charAt(tmpIdx1)!=cur){
//        tmpIdx1++;
//        }
//
//
//        while(tmpIdx2 < secondString.length && secondString.charAt(tmpIdx2)!=cur){
//        tmpIdx2++;
//        }
//
//
//        if(tmpIdx2 == secondString.length && tmpIdx1 == firstString.length){
//        return false;
//        }else if(tmpIdx2 != secondString.length){
//        idx2 = tmpIdx2;
//        }else {
//        idx1 = tmpIdx1;
//        }
//        }
//        return true;
//
//
