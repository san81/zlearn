package com.san.learn;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {

        int mod = 1000000007;
        public int countPairs_(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = arr.length;
            long res = 0;
            for (int num : arr) {
                int power = 1;
                for (int i = 0; i < 32; i++) {
                    if (map.containsKey(power - num)) {
                        res += map.get(power - num);
                        res %= mod;
                    }
                    power *= 2;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
                System.out.println(map);
                System.out.println(res);
            }
            return (int) res;
        }

    static boolean isPowerOfTwo (int x)
    {
      /* First x in the below expression is
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);

    }

    public int countPairs(int[] arr) {
        Map<Integer, Integer> numOccurence = new HashMap<>();
        int n = arr.length;
        int pairCnt = 0;
        for (int num: arr) {
            for (Map.Entry<Integer, Integer> entry: numOccurence.entrySet()) {
                if(isPowerOfTwo(num+entry.getKey())) {
                    pairCnt+= entry.getValue();
                }
            }

            int curVal = numOccurence.getOrDefault(num, 0);
            numOccurence.put(num, curVal+1);

        }
        return pairCnt;
    }

    public static void main(String ar[]) {
        //int[] arr = new int[]{1,3,5,7,9};
        int[] arr = new int[]{1,1,1,3,3,3,7};

        System.out.println(new CountGoodMeals().countPairs_(arr));
    }

}
