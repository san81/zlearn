package com.san.learn;

import java.util.Arrays;

public class BestTimeToBuyAndSell {


        public int maxProfit(int[] prices) {
            int[] profit = new int[prices.length];

            for (int i = 0; i < prices.length - 1; i++) {
                int max_profit = 0;
                for (int j = i+1; j < prices.length; j++) {
                    int cur_profit = prices[j] - prices[i];
                    if(cur_profit<0){
                        cur_profit = 0;
                    }
                    max_profit = Math.max(max_profit, cur_profit + profit[j-1]);
                    profit[j] = max_profit;
                }
                System.out.println(Arrays.toString(profit));
            }
            return profit[profit.length-1];
        }

        public static void main(String ar[]){
            BestTimeToBuyAndSell btb = new BestTimeToBuyAndSell();
            int[] input = new int[]{1, 2, 3, 4, 5};
            int profit = btb.maxProfit(input);
            System.out.println(profit);
        }


}
