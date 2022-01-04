package com.san.learn;

import java.time.LocalDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
 * Medium
 *
 * 75
 *
 * 131
 *
 * Add to List
 *
 * Share
 * LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.
 *
 * You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.
 *
 * Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".
 *
 * Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.
 *
 * Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.
 *
 *
 *
 * Example 1:
 *
 * Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * Output: ["daniel"]
 * Explanation: "daniel" used the keycard 3 times in a one-hour period ("10:00","10:40", "11:00").
 * Example 2:
 *
 * Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * Output: ["bob"]
 * Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:20", "21:30").
 * Example 3:
 *
 * Input: keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * Output: []
 * Example 4:
 *
 * Input: keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * Output: ["clare","leslie"]
 */

class KeyCardAlertingSystem1 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String[] strs = keyTime[i].split(":");
            int time = Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
            if (!map.containsKey(name)) map.put(name, new ArrayList<>());
            map.get(name).add(time);
        }
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            if (list.size() < 3) continue;
            Collections.sort(list);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}

public class KeyCardAlertingSystem {

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> alertUser = new TreeSet<>();

        Map<String, List<Integer>> perUserKeyTimes = new HashMap<>();
        for(int i=0;i<keyName.length; i++) {
            List<Integer> curQueue = perUserKeyTimes.computeIfAbsent(keyName[i], k -> new ArrayList<>());
            String[] hrMin = keyTime[i].split(":");
            Integer latestTime = (Integer.parseInt(hrMin[0]) * 60) + Integer.parseInt((hrMin[1]));
            curQueue.add(latestTime);
        }

        for(Map.Entry<String, List<Integer>> userKeyTimes: perUserKeyTimes.entrySet()) {
            System.out.println(userKeyTimes.getKey());
            List<Integer> keyTimes = userKeyTimes.getValue();
            if(keyTimes.size()<3) continue;
            Collections.sort(keyTimes);
            for(int i=2; i<keyTimes.size(); i++ ) {
                if(keyTimes.get(i) - keyTimes.get(i-2) <= 60) {
                    alertUser.add(userKeyTimes.getKey());
                }
            }
        }
        return new ArrayList<>(alertUser);
    }

    public static void main(String ar[]) {
//        String[] keyName = new String[]{"alice","alice","alice","bob","bob","bob","bob"};
//        String[] keyTime = new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};

//        String[] keyName = new String[]{"leslie","leslie","leslie","clare","clare","clare","clare"};
//        String[] keyTime = new String[]{"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};

//        String[] keyTime = new String[]{"23:58","23:59","00:01"};
//        String[] keyName = new String[]{"john","john","john"};

//        String[] keyName = new String[]{"a","a","a","a","a","a","b","b","b","b","b"};
//        String[] keyTime = new String[]{"23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41"};

        String[] keyName = new String[]{"a","a","a","a","a","b","b","b","b","b","b"};
        String[] keyTime = new String[]{"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"};


        System.out.println(alertNames(keyName, keyTime));

    }
}
