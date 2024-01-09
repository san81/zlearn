package com.san;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
    Set<Set<Integer>> ans = new HashSet<>();

    public boolean backtrack(int k, int n, Set<Integer> list) {
        if(n==0 && k==0) {
            return true;
        }else if(k==0 && n>0) {
            return false;
        }

        for(int i=1;i<=9;i++) {
            if(!list.contains(i) && i<=n) {
                list.add(i);
                boolean foundAPair = backtrack(k-1, n-i, list);
                if(foundAPair) {
                    this.ans.add(new HashSet<>(list));
                }
                list.remove(i);
            }
        }
        return false;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, new HashSet<Integer>());
        List<List<Integer>> listAns = new ArrayList<>();
        for(Set<Integer> pair:this.ans) {
            listAns.add(new ArrayList<>(pair));
        }
        return listAns;
    }

    public static void main(String[] args) {
        CombinationSumIII cs = new CombinationSumIII();
        System.out.println(cs.combinationSum3(3, 7));
    }
}
