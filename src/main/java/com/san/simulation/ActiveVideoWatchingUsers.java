package com.san.simulation;

import java.util.*;

/**
 * You are part of the analytics team at a video streaming platform. Every time a user watches a video, the platform generates an event with the user’s ID.
 * The product team wants to identify the most active users in recent activity for analytics and targeted recommendations.
 * Your task is to build a function that finds the top-K most active users in every sliding window of recent events.
 * Problem Statement
 * Input:
 * events: a list of integers representing user IDs (may repeat)
 * window_size: the number of consecutive events to consider in a sliding window
 * top_k: the number of most frequent users to return per window
 * Output:
 * A list of lists. Each sublist contains the top-K users for that window
 * Example:
 * events = [1, 2, 1, 3, 4, 2, 3]
 * window_size = 4
 * top_k = 2
 * Output: [[1, 2], [1, 2], [1, 3], [3, 2]]
 * Explanation:
 * •⁠  ⁠Window 1: [1,2,1,3] → frequencies {1:2,2:1,3:1} → top-2: [1,2]   # ;  k:event_id; v: freq
 * •⁠  ⁠Window 2: [2,1,3,4] → frequencies {2:1,1:1,3:1,4:1} → top-2: [1,2] (or any two with frequency 1)
 * •⁠  ⁠Window 3: [1,3,4,2] → frequencies {1:1,3:1,4:1,2:1} → top-2: [1,3]
 * •⁠  ⁠Window 4: [3,4,2,3] → frequencies {3:2,4:1,2:1} → top-2: [3,2]
 * Constraints
 * 1 ≤ window_size ≤ len(events)
 * 1 ≤ top_k ≤ window_size
 *
 */
public class ActiveVideoWatchingUsers {

    int[] events = new int[]{1, 2, 1, 3, 4, 2, 3};
    int windowSize = 4;
    int topK = 2;

    Map<Integer, Set<Integer>> frequencyToNumbers = new TreeMap<>(Comparator.reverseOrder());
    Map<Integer, Integer> numberToFrequency = new HashMap<>();


    public void remove(int num) {
        int freq = numberToFrequency.get(num);
        Set<Integer> currentNumbers = frequencyToNumbers.get(freq);
        currentNumbers.remove(num);
        if(currentNumbers.size()==0) {
            frequencyToNumbers.remove(freq);
        }
        freq--;
        if(freq>0) {
            frequencyToNumbers.computeIfAbsent(freq, f -> new TreeSet<>()).add(num);
            numberToFrequency.put(num, freq);
        }else {
            numberToFrequency.remove(num);
        }
    }

    public void addNum(int num) {

        int freq = numberToFrequency.getOrDefault(num, 0);
        if(freq==0) {
            numberToFrequency.put(num, 1);
            frequencyToNumbers.computeIfAbsent(1, n -> new TreeSet<>()).add(num);
        }else {
            Set<Integer> currentNumbers = frequencyToNumbers.computeIfAbsent(freq, n -> new TreeSet<>());
            if(currentNumbers.size()>0) {
                currentNumbers.remove(num);
                if(currentNumbers.size()==0) {
                    frequencyToNumbers.remove(freq);
                }
            }
            frequencyToNumbers.computeIfAbsent(freq+1, f -> new TreeSet<>()).add(num);
            numberToFrequency.put(num, freq+1);
        }
    }

    public List<Integer> getTopK() {
        List<Integer> result = new ArrayList<>();

        for (int freq : frequencyToNumbers.keySet()) {
            for (int num : frequencyToNumbers.get(freq)) {
                result.add(num);
                if (result.size() == topK) return result;
            }
        }
        return result;
    }

    public List<List<Integer>> videoWatchingUsers() {

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < events.length; i++) {
            addNum(events[i]);
            if (i >= windowSize - 1) {
                answer.add(getTopK());
                remove(events[i - windowSize + 1]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ActiveVideoWatchingUsers avw = new ActiveVideoWatchingUsers();
        System.out.println(avw.videoWatchingUsers());
    }
}
