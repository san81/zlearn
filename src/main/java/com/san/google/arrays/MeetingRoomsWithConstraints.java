package com.san.google.arrays;

import java.util.*;

/*
 *
# Given a set of [start, end) intervals for meetings, what is the minimum
# number of rooms needed to accommodate meetings?

# If a meeting ends at the same as another meeting starts, there is no overlap.

# Times are given as integers. The solution should scale to arbitrarily large values.

meetings = [ [1,10], [4, 6], [3, 6], [2, 9], [11, 14], [14, 16], [12,13], [6,8], [9,14] ]

instead of 4, if we have only 3 rooms, what meetings we cancel?

two strategis:
  - what if we want to support long meetings? vs short meetings? or vice versa
  - long meeting is at least

 */

public class MeetingRoomsWithConstraints {


    static class Meeting {
        int start;
        int end;
        int duration;

        Meeting(int s, int e) {
            start = s;
            end = e;
            duration = e - s;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String[] args) {

        List<int[]> meetings = new ArrayList<>(List.of(
                new int[]{1,10}, new int[]{2,3}, new int[]{4,6},
                new int[]{3,6}, new int[]{2,9}, new int[]{11,14},
                new int[]{14,16}, new int[]{12,13}, new int[]{6,8},
                new int[]{9,14}
        ));

        Collections.sort(meetings, (a,b)->{
            if(a[0]==b[0])
                return (a[1]-a[0]) - (b[1]-b[0]);
            return a[0]-b[0];
        });

        PriorityQueue<Meeting> endHeap =
                new PriorityQueue<>(Comparator.comparingInt(m->m.end));

        PriorityQueue<Meeting> durationHeap =
                new PriorityQueue<>((a,b)->b.duration-a.duration);

        List<Meeting> rejected = new ArrayList<>();
        List<Meeting> approved = new ArrayList<>();

        int MAX_ROOMS = 3;

        for(int[] m : meetings) {

            Meeting meeting = new Meeting(m[0], m[1]);

            // remove finished meetings
            while(!endHeap.isEmpty() && endHeap.peek().end <= meeting.start) {
                Meeting finished = endHeap.poll();
                durationHeap.remove(finished);
            }

            endHeap.add(meeting);
            durationHeap.add(meeting);

            if(endHeap.size() > MAX_ROOMS) {

                Meeting longest = durationHeap.poll();
                endHeap.remove(longest);

                rejected.add(longest);

                if(longest != meeting) {
                    approved.add(meeting);
                }

            } else {
                approved.add(meeting);
            }
        }

        System.out.println("Approved meetings:");
        approved.forEach(System.out::println);

        System.out.println("\nRejected meetings:");
        rejected.forEach(System.out::println);
    }
}