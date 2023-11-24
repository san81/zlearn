package com.san;

import java.util.Arrays;

public class ArrayRotate {
  public void rotate(int[] nums, int k) {

    k = k % nums.length;
    int count = 0;

    for (int i = 0; count < nums.length; i++) {
      int current = i;
      int curVal = nums[i];
      do {
        current = (current + k) % nums.length;
        int tmp = nums[current];
        nums[current] = curVal;
        curVal = tmp;
        count++;
      } while (current != i);
    }

  }

  public static void main(String[] args) {
    ArrayRotate ar = new ArrayRotate();
    int[] nums = new int[]{1,2,3,4,5,6};
    ar.rotate(nums, 3);
    System.out.println(Arrays.toString(nums));

  }
}
