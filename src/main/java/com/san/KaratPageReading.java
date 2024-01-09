package com.san;

/*

As you are reading the book multiple times, you notice that you often get bad endings. You start to suspect there is no way to get to the good endings, so you decide to find out.

Good and bad endings will be separate lists of page numbers, like this:

good_endings = [10, 15, 25, 34]
bad_endings = [21, 30, 40]

Given lists of good endings, bad endings, and a list of the choices along with their options, return a collection of all the reachable good endings, if any.

Examples:

choices1 = [[3, 16, 24]]
find_good_endings(good_endings, bad_endings, choices1)
  Start: 1 -> 2 -> 3(choice) -> 16 -> 17... -> 21(bad ending)
                   |
                   -> 24 -> 25(good ending)
Thus it is possible to reach the good ending at 25 but no others, so we return [25].

choices2 = [[3, 16, 20]]
find_good_endings(good_endings, bad_endings, choices2)
  Start: 1 -> 2 -> 3(choice) -> 16 -> 17... -> 21(bad ending)
                   |
                   > 20 -> 21(bad ending)
No good ending is reachable, so return [].

choices3 = [[3, 16, 19], [20, 2, 17]]
find_good_endings(good_endings, bad_endings, choices3)
                                      +------<-------<----+
                                      v                   |
  Start: 1 -> 2 -> 3(choice) -> 16 -> 17 -> 18 -> 19 -> 20(choice)
              ^       |                           ^       |
              |       +----->------->------>------+       v
              +-------<--------<-------<-------<----------+

No good ending is reachable, so return [].

Additional Inputs:
choices4 = [[3, 2, 19], [20, 21, 34]]
choices5 = []
choices6 = [[9, 16, 26], [14, 16, 13], [27, 29, 28], [28, 15, 34], [29, 30, 38]]
choices7 = [[9, 16, 26], [13, 31, 14], [14, 16, 13], [27, 12, 24], [32, 34, 15]]
choices8 = [[3, 9, 10]]
choices9 = [[3, 9, 10], [12, 13, 14]]

Complexity Variable:
n = number of pages
(endings and choices are bound by the number of pages)

All Test Cases - snake_case:
find_good_endings(good_endings, bad_endings, choices1) => [25]
find_good_endings(good_endings, bad_endings, choices2) => []
find_good_endings(good_endings, bad_endings, choices3) => []
find_good_endings(good_endings, bad_endings, choices4) => [34]
find_good_endings(good_endings, bad_endings, choices5) => [10]
find_good_endings(good_endings, bad_endings, choices6) => [15, 34]
find_good_endings(good_endings, bad_endings, choices7) => [15, 25, 34]
find_good_endings(good_endings, bad_endings, choices8) => [10]
find_good_endings(good_endings, bad_endings, choices9) => [10]

All Test Cases - camelCase:
findGoodEndings(goodEndings, badEndings, choices1) => [25]
findGoodEndings(goodEndings, badEndings, choices2) => []
findGoodEndings(goodEndings, badEndings, choices3) => []
findGoodEndings(goodEndings, badEndings, choices4) => [34]
findGoodEndings(goodEndings, badEndings, choices5) => [10]
findGoodEndings(goodEndings, badEndings, choices6) => [15, 34]
findGoodEndings(goodEndings, badEndings, choices7) => [15, 25, 34]
findGoodEndings(goodEndings, badEndings, choices8) => [10]
findGoodEndings(goodEndings, badEndings, choices9) => [10]

*/

import java.io.*;
import java.util.*;

public class KaratPageReading {

    public static Integer[] findGoodEndings(int[] goodEndings, int[] badEndings, int[][] choices) {

        int endPage = goodEndings[badEndings.length-1];
        if(choices.length==0) {
            return new Integer[]{endPage};
        }

        Map<Integer, int[]> choicesSet = new HashMap<>();
        for(int i=0;i<choices.length;i++) {
            choicesSet.put(choices[i][0], choices[i]);
        }

        Set<Integer> goodEndPages = new HashSet<Integer>();
        for(int i=0;i<goodEndings.length;i++) {
            goodEndPages.add(goodEndings[i]);
        }


        List<Integer> endings = new ArrayList<>();
        endings = stories(0, endPage, goodEndPages, goodEndPages, choicesSet);
        int[] ans = new int[0];
        return endings.toArray(new Integer[0]);
    }

    public static List<Integer> stories(int start, int endPage,
                                        Set<Integer> goodEndings,
                                        Set<Integer> badEndings,
                                        Map<Integer, int[]> choicesSet) {



        Set<Integer> visited = new HashSet<Integer>();

        while(start<endPage) {

            if(visited.contains(start)) {
                List<Integer> ans =  new ArrayList<>();
                ans.add(-1);
                return ans;
            }else{
                visited.add(start);
            }

            if(goodEndings.contains(start)) {
                List<Integer> ans =  new ArrayList<>();
                ans.add(start);
                return ans;
            }

            if(choicesSet.get(start)!=null) {
                int[] choicePage = choicesSet.get(start);
                start = choicePage[1];
            }else{
                start++;
            }
        }
        List<Integer> ans =  new ArrayList<>();
        ans.add(start);
        return ans;
    }

    public static void main(String[] argv) {
        int[] good_endings = {10, 15, 25, 34};
        int[] bad_endings = {21, 30, 40};

        int[][] choices1 = {
                {3, 16, 24},
        };
        int[][] choices2 = {
                {3, 16, 20},
        };
        int[][] choices3 = {
                {3, 16, 19},
                {20, 2, 17},
        };
        int[][] choices4 = {
                {3, 2, 19},
                {20, 21, 34},
        };
        int[][] choices5 = {};
        int[][] choices6 = {
                {9, 16, 26},
                {14, 16, 13},
                {27, 29, 28},
                {28, 15, 34},
                {29, 30, 38},
        };
        int[][] choices7 = {
                {9, 16, 26},
                {13, 31, 14},
                {14, 16, 13},
                {27, 12, 24},
                {32, 34, 15},
        };
        int[][] choices8 = {
                {3, 9, 10},
        };
        int[][] choices9 = {
                {3, 9, 10},
                {12, 13, 14},
        };

        // System.out.println(stories(endings1, choices1_1, 1));
        // System.out.println(stories(endings1, choices1_1, 2) ); // -1
        // System.out.println(stories(endings1, choices1_2, 1));// == 15);
        // System.out.println(stories(endings1, choices1_2, 2));// == -1);
        // System.out.println(stories(endings1, choices1_3, 1));// => 21
        // System.out.println(stories(endings1, choices1_3, 2));// => 30
        // System.out.println(stories(endings1, choices1_4, 1));// => -1
        // System.out.println(stories(endings1, choices1_4, 2));// => 15
        // System.out.println(stories(endings2, choices2_1, 1));// => 11
        // System.out.println(stories(endings2, choices2_1, 2));// => -1
        // System.out.println(stories(endings2, choices2_2, 1));// => 11
        // System.out.println(stories(endings2, choices2_2, 2));// => 11
        // System.out.println(stories(endings3, choices3_1, 1));// => 4
        // System.out.println(stories(endings3, choices3_1, 2));// => 4

    }
}

