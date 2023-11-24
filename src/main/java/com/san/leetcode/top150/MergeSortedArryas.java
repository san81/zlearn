package com.san.leetcode.top150;

import java.util.Arrays;

public class MergeSortedArryas {

  //Two pointer solution
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, p = nums1.length - 1;
    while (p > 0 && i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[p--] = nums1[i--];
      } else {
        nums1[p--] = nums2[j--];
      }
    }
    while (j >= 0) {
      nums1[p--] = nums2[j--];
    }
    System.out.println(Arrays.toString(nums1));
  }

  public void merge_copy(int[] nums1, int m, int[] nums2, int n) {
    int len = m + n;
    int p1 = 0, p2 = 0;
    int[] result = new int[len];
    int i = 0;
    while (p1 < m && p2 < n) {
      if (nums1[p1] >= nums2[p2]) {
        result[i++] = nums2[p2];
        p2++;
      } else {
        result[i++] = nums1[p1];
        p1++;
      }
    }

    if (p1 < m && p2 >= n) {
      for (int j = p1; j < m; j++) {
        result[i++] = nums1[j];
      }
    } else {
      for (int j = p2; j < n; j++) {
        result[i++] = nums2[j];
      }
    }
    for (int k = 0; k < len; k++) {
      nums1[k] = result[k];
    }
    System.out.println(Arrays.toString(nums1));
  }

  public static void main(String ar[]) {
    MergeSortedArryas mergeSortedArryas = new MergeSortedArryas();
    int[] num1 = new int[] {1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[] {2, 5, 6};
    int m = 3, n = 3;
    mergeSortedArryas.merge(num1, m, nums2, n);
  }
}
