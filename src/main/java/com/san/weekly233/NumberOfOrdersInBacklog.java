package com.san.weekly233;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfOrdersInBacklog {
    public boolean isBuyOrSellCheck(int priceOne, int priceTwo, int buyOrSell){
        if(buyOrSell==0) {
            return priceOne <= priceTwo;
        }else{
            return priceTwo <= priceOne;
        }
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> buyBacklog = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);

        Queue<int[]> sellBacklog = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);

        for(int[] order:orders) {
            Queue<int[]> backlogToRemove = buyBacklog;
            Queue<int[]> backlogToAdd = sellBacklog;
            if(order[2]==0) {
                backlogToRemove = sellBacklog;
                backlogToAdd = buyBacklog;
            }

            //buy action
            int[] topFromBacklog = backlogToRemove.peek();
            int ordersToRemove = 0;
            while(topFromBacklog!=null &&
                    isBuyOrSellCheck(topFromBacklog[0], order[0], order[2]) &&
                    ordersToRemove<order[1] &&
                    backlogToRemove.size()>0){
                if(ordersToRemove+topFromBacklog[1]>order[1]) {
                    int diff = (order[1]-ordersToRemove);
                    topFromBacklog[1] -=diff;
                    ordersToRemove += diff;

                }else{
                    ordersToRemove+=topFromBacklog[1];
                    backlogToRemove.remove();
                    topFromBacklog = backlogToRemove.peek();
                }
            }
            if(ordersToRemove!=order[1]) {
                order[1] -= ordersToRemove;
                backlogToAdd.offer(order);
            }
        }

        //sum of all the orders
        int finalLeftOrder = 0;
        while(buyBacklog.size()>0){
            finalLeftOrder += buyBacklog.poll()[1];
            finalLeftOrder %= ((int)Math.pow(10, 9)+7);
        }
        while(sellBacklog.size()>0){
            finalLeftOrder += sellBacklog.poll()[1];
            finalLeftOrder %= ((int)Math.pow(10, 9)+7);
        }
        return finalLeftOrder ;
    }

    public static void main(String[] args) {
//        int[][] orders = new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}}; // expected ans = 6
//        int[][] orders = new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}; // expeced ans = 999999984
//          int[][] orders = new int[][]{{19,28,0},{9,4,1},{25,15,1}};
//        int[][] orders = new int[][]{{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}}; // exp 34
        int[][] orders = new int[][]{{944925198,885003661,0},{852263791,981056352,0},{16300530,415829909,0},{940927944,713835606,0},{606389372,407474168,1},{139563740,85382287,1},{700244880,901922025,1},{972900669,15506445,0},{576578542,65339074,0},{45972021,293765308,0},{464403992,97750995,0},{29659852,536508041,0},{799523481,299864737,0},{711908211,480514887,1},{354125407,677598767,1},{279004011,688916331,0},{263524013,64622178,0},{375395974,460070320,0},{971786816,379275200,1},{577774472,214070125,1},{987757349,711231195,0}};
        System.out.println(new NumberOfOrdersInBacklog().getNumberOfBacklogOrders(orders));
    }
}
