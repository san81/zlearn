package com.san.amazon;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if(n==0){
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lMax = height[0];
        int rMax = height[n-1];
        for(int i=0, j=n-1;i<n;i++, j--){
            if(height[i]>=lMax){
                lMax = height[i];
            }
            if(height[j]>=rMax){
                rMax = height[j];
            }
            leftMax[i] = lMax;
            rightMax[j] = rMax;
        }
        int area = 0;
        for(int i=0;i<n;i++){
            area += Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return area;
    }

    public static void main(String[] args) {
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
