package com.san.weekly487;

import org.junit.Assert;

public class LongestAlternateSubArray {
    public int maxAlternatingSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        // required by problem
        int[] nexoraviml = nums;

        int ans = 1;

        int left = 0;
        int lastSign = 0;   // 1 = up, -1 = down
        boolean usedRemoval = false;

        for (int right = 1; right < n; right++) {
            int diff = nexoraviml[right] - nexoraviml[right - 1];
            int sign = diff == 0 ? 0 : (diff > 0 ? 1 : -1);

            if (sign == 0 || (lastSign != 0 && sign == lastSign)) {
                // alternation breaks
                if (!usedRemoval) {
                    // try removing nums[right - 1]
                    usedRemoval = true;
                    lastSign = sign;
                } else {
                    // must restart
                    left = right - 1;
                    usedRemoval = false;
                    lastSign = sign;
                }
            } else {
                lastSign = sign;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestAlternateSubArray obj = new LongestAlternateSubArray();
        Assert.assertEquals(4, obj.maxAlternatingSubarray(new int[]{2,1,3,2}));
        Assert.assertEquals(4, obj.maxAlternatingSubarray(new int[]{3,2,1,2,3,2,1}));
        Assert.assertEquals(1, obj.maxAlternatingSubarray(new int[]{100000,100000}));

    }
}
