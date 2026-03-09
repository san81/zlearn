package com.san.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InstallationTracker {

    Map<String, List<Integer>> map = new HashMap<>();

    public void add(String type, int distance) {
        map.putIfAbsent(type, new ArrayList<>());
        map.get(type).add(distance);
    }

    public int minDistance(String type1, String type2) {
        List<Integer> A = map.get(type1);
        List<Integer> B = map.get(type2);

        if (A == null || B == null) return -1;

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size()) {
            min = Math.min(min, Math.abs(A.get(i) - B.get(j)));

            if (A.get(i) < B.get(j)) i++;
            else j++;
        }

        return min;
    }

    public int maxDistance(String type1, String type2) {
        List<Integer> A = map.get(type1);
        List<Integer> B = map.get(type2);

        if (A == null || B == null) return -1;

        return Math.max(
                Math.abs(A.get(0) - B.get(B.size() - 1)),
                Math.abs(A.get(A.size() - 1) - B.get(0))
        );
    }
}

