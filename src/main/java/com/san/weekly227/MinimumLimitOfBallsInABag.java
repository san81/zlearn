package com.san.weekly227;

import java.util.*;

class Bag {
    int num;
    int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return num == bag.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}

public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] A, int k) {
        int left = 1, right = 1_000_000_000;
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int a : A)
                count += (a - 1) / mid;
            if (count > k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    /*public int minimumSize(int[] nums, int maxOperations) {
        Set<Integer> uniqNums = new TreeSet<>();
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int n:nums){
            uniqNums.add(n);
            Integer defaultCount = numToCount.getOrDefault(n, 1);
            numToCount.put(n, defaultCount++);
        }

        int n = nums.length-1;
        int ops = 0;
        while(ops<maxOperations) {
            int curMax = uniqNums.iterator().next();
            int countOfCurrentMax = numToCount.get(curMax);

            if(countOfCurrentMax>maxOperations){
                return curMax;
            }else if(countOfCurrentMax==maxOperations){
                if(curMax%2==0){
                    return curMax/2;
                }else{
                    return (curMax/2)+1;
                }
            }else{
                uniqNums.remove(curMax);
                if(curMax%2==0){
                    int half = curMax/2;
                    addANumberToTheCollection(uniqNums, numToCount, half, countOfCurrentMax*2);
                }else{
                    int firstHalf = curMax/2;
                    int secondHalf = curMax - firstHalf;
                    addANumberToTheCollection(uniqNums, numToCount, firstHalf, countOfCurrentMax);
                    addANumberToTheCollection(uniqNums, numToCount, secondHalf, countOfCurrentMax);
                }

            }
            ops += countOfCurrentMax;
        }
        return uniqNums.iterator().next();
    }

    public void addANumberToTheCollection(Set<Integer> uniqNums, Map<Integer, Integer> numToCount, int numToAdd, int countOfCurrentMax) {
        uniqNums.add(numToAdd);
        int sofarCunt = numToCount.getOrDefault(numToAdd, 0);
        numToCount.put(numToAdd, sofarCunt+(countOfCurrentMax));
    }*/

    public static void main(String[] args) {
        int[] nums = new int[]{9};
        int maxOperations = 2;
        System.out.println(new MinimumLimitOfBallsInABag().minimumSize(nums, maxOperations));
    }
}
