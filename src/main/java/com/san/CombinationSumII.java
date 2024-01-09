package com.san;

import java.util.*;

public class CombinationSumII {

    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates;

    public boolean backtrack(int start, int n, List<Integer> list) {
        if(n==0) {
            return true;
        }

        for(int in=start;in<this.candidates.length;in++) {

            int i = this.candidates[in];
            if(i<=n) {
                list.add(i);
                boolean foundAPair = backtrack(in+1, n-i, list);
                if(foundAPair) {
                    this.ans.add(new ArrayList<>(list));
                }
                list.remove(list.size()-1);
            }
            //Skipping the duplicate copy evalution
            while(in<this.candidates.length-1 && this.candidates[in]==this.candidates[in+1] ) {
                in++;
            }
        }
        return false;
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;

        backtrack(0, target, new LinkedList<Integer>());
        return this.ans;
    }

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        System.out.println(cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
