package com.san.zoox;

public class NumberOfHorses {

    public static int minHorses(String s) {
        String neigh = "neigh";
        // inProgress[i] = horses currently waiting for neigh[i]
        // idle = horses that finished a full 'neigh' and can say it again
        int[] inProgress = new int[5];
        int idle = 0, total = 0;
        for (char c : s.toCharArray()) {
            boolean assigned = false;
            for (int i = 4; i >= 0; i--) {  // greedy: advance furthest-along horse
                if (neigh.charAt(i) == c && inProgress[i] > 0) {
                    inProgress[i]--;
                    if (i == 4) idle++;          // FIX: finished horse joins idle pool
                    else inProgress[i + 1]++;    // advance to next letter
                    assigned = true;
                    break;
                }
            }
            if (!assigned && c == 'n') {
                if (idle > 0) idle--;            // FIX: reuse a finished horse
                else total++;                    // no idle horse available, need a new one
                inProgress[1]++;                 // horse now needs 'e'
            }
        }
        return total;
    }
// 'neighneigh' -> 1  |  'nneigheigh' -> 2


    public static void main(String[] args) {
        System.out.println(minHorses("neighneigh"));
        System.out.println(minHorses("nneigheigh"));
    }
}
