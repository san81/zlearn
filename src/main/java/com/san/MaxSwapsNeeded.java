package com.san;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//class GFG {
//
//    // checks whether a String has similar characters side by side
//    static boolean sameJavaharAdj(char str[]) {
//        int n = str.length, i;
//        TreeSet<Character> st = new TreeSet<>();
//        st.add(str[0]);
//        for (i = 1; i < n; i++) {
//
//            // If similar chars side by side, continue
//            if (str[i] == str[i - 1]) {
//                continue;
//            }
//
//            // If we have found a char equal to current
//            // char and does not exist side to it,
//            // return false
//            if (st.contains(str[i]) & (str[i] != st.last())) {
//                return false;
//            }
//            st.add(str[i]);
//        }
//        return true;
//    }
//
//    // counts min swap operations to convert a String
//// that has similar characters side by side
//    static int minSwaps(char str[], int l, int r, int cnt, int minm) {
//        // Base case
//        if (l == r) {
//            if (sameJavaharAdj(str)) {
//                return cnt;
//            } else {
//                return Integer.MAX_VALUE;
//            }
//        }
//
//        for (int i = l + 1; i <= r; i++) {
//            swap(str, i, l);
//            cnt++;
//
//            // considering swapping of i and l chars
//            int x = minSwaps(str, l + 1, r, cnt, minm);
//
//            // Backtrack
//            swap(str, i, l);
//            cnt--;
//
//            // not considering swapping of i and l chars
//            int y = minSwaps(str, l + 1, r, cnt, minm);
//
//            // taking Math.min of above two
//            minm = Math.min(minm, Math.min(x, y));
//        }
//
//        return minm;
//    }
//
//    static void swap(char[] arr, int i, int j) {
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//// Driver code
//
//    public static void main(String[] args) {
//        String str = "abbaacb";
//        int n = str.length(), cnt = 0, minm = Integer.MAX_VALUE;
//        System.out.print(minSwaps(str.toCharArray(), 0, n - 1, cnt, minm));;
//    }
//}

public class MaxSwapsNeeded {
    public int solution(String S) {
        // write your code in Java SE 8
        char[] letters = S.toCharArray();
        List<Integer> rIdx = new ArrayList<>();
        for(int i=0;i<letters.length; i++){
            if(letters[i]=='R'){
                rIdx.add(i);
            }
        }

        /*
            Create group of R and weigh them
         */

        System.out.println(rIdx.toString());
        return 0;

    }

    public static void main(String ar[]){
        MaxSwapsNeeded oc = new MaxSwapsNeeded();
        oc.solution("WRRWRW");
        oc.solution("WWRWWWRWR");
        oc.solution("WWRWWWRWRWWRRWW");
    }
}
