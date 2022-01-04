package com.san.google.arrays;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> nextInt = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int maxRooms = 0;
        int curNeed = 0;
        for(int[] meeting: intervals) {
            if(nextInt.size()==0) {
                curNeed++;
            }else {
                Integer peek = nextInt.peek();
                if(meeting[0]<peek) {
                    curNeed++;
                }else{
                    nextInt.poll();
                }
            }
            nextInt.add(meeting[1]);
            if(curNeed>maxRooms){
                maxRooms = curNeed;
            }
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        System.out.println(mr.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        Assert.assertEquals(mr.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}), 2);
        Assert.assertEquals(mr.minMeetingRooms(new int[][]{{7,10},{2,4}}), 1);
    }
}
