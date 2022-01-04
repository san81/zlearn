package com.san.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a list of unordered entry/exit events of employess entering a building,
 * find out the time where the max occupancy was met.
 *
 * Add ons:
 * Return all the minutes where the max is met
 * Consider the case where some employees were staying over night
 */
public class MaxOccupancy {
    public static void main(String[] args) {
        int base = 0; // Overflowing from the past day
        // Tracking the count at the minute granularity
        int[] occupancy = new int[1440];
        for(int i=0;i<1440;i++){
            occupancy[i] = base; //filling up over night staying capacity
        }

        Map<Integer, List<Integer>> perOccupancyMinutes = new HashMap<>();
        Map<Integer, List<String>> entryExistEvents = new HashMap<>();
        int max = 0;
        for(Map.Entry<Integer, List<String>> entry: entryExistEvents.entrySet()) {
            int minute = entry.getKey();
            for(String entryOrExist:entry.getValue()) {
                if("entry".equals(entryOrExist)) {
                    occupancy[minute]++;
                }else {
                    occupancy[minute]--;
                }

                perOccupancyMinutes.get(occupancy[minute]).add(minute);
                if(max<occupancy[minute]) {
                    max = occupancy[minute];
                }

            }
        }
        //return perOccupancyMinutes.get(max);
        System.out.println(perOccupancyMinutes.get(max));

    }

}
