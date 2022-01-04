package com.san.amazon;


import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Set<Integer>> unique = new HashMap<>();
        for(int n=0; n<nums.length; n++){
            Set<Integer> idxs = unique.getOrDefault(nums[n], new HashSet<>());
            idxs.add(n);
            unique.put(nums[n],idxs);
        }
        for(int n=0; n<nums.length; n++){
            Set<Integer> idxs = unique.get(target - nums[n]);
            if(null!= idxs){
                Iterator<Integer> iterator = idxs.iterator();
                while(iterator.hasNext()){
                    Integer curIdx = iterator.next();
                    if(curIdx==n) {
                        continue;
                    }else{
                        return new int[]{n, curIdx};
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;
        int[] nums = new int[]{3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}