package com.san.amazon;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r= height.length-1;
        while(l<r) {
           int cArea = (r-l)*Math.min(height[l],height[r]);
           if(cArea>maxArea){
               maxArea = cArea;
               System.out.println(l+" "+r+" "+cArea);
           }
           if(height[l]<height[r]){
               l++;
           }else{
               r--;
           }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        //height = new int[] {1,1};
        //height = new int[] {4,3,2,1,4};
        //height = new int[]{1,2,1};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
