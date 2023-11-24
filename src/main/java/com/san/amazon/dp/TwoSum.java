package com.san.amazon.dp;

import java.util.Arrays;

public class TwoSum {
  public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      int idx = bsearch(numbers, target - numbers[i]);
      if (idx != -1 && idx != i) {
        return new int[] {i, idx};
      }
    }
    return null;
  }

  public int bsearch(int[] numbers, int target) {
    int low = 0;
    int high = numbers.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (numbers[mid] == target) {
        return mid;
      } else if (numbers[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    TwoSum ts = new TwoSum();
    int[] numbers = new int[] {2, 7, 11, 15};
    int target = 9;
//    int[] answer = ts.twoSum(numbers, target);

    numbers = new int[] {2, 3, 4};
    target = 6;
//    int[] answer =  ts.twoSum(numbers, target);

    numbers = new int[]{-1,0};
    target = -1;
//    int[] answer =  ts.twoSum(numbers, target);
    numbers = new int[]{1,2,3,4,4,9,56,90};
    target = 8;
    int[] answer =  ts.twoSum(numbers, target);
    System.out.println(Arrays.toString(answer));
  }
}
