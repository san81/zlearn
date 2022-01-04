package com.san;

import java.util.Arrays;
import java.util.List;

public class StockValues {



     public static int maxProfit(int[] stockValues) {
         int maxProfit = Integer.MIN_VALUE;
         int CHARGES = 2;

         int[] profits = new int[stockValues.length];

         for(int i=0; i<stockValues.length; i++) {

            int curProfit = 0;
            for(int j=i+1; j<stockValues.length; j++){
                curProfit = (stockValues[j] - stockValues[i])-CHARGES;
                if(curProfit<0){
                    curProfit=0;
                }
                maxProfit = Math.max(maxProfit, curProfit+profits[j-1]);
                profits[j] = maxProfit;
            }
             System.out.println(Arrays.toString(profits));
         }

         return profits[stockValues.length-1];
     }

     public static void main(String ar[]) {
         int[] stockValues = new int[]{9, 4, 5, 7, 10, 2, 15};
         int maxProfit = maxProfit(stockValues);
         System.out.println(maxProfit);

     }

}
