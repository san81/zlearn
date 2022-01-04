package com.san.weekly230;

import java.util.ArrayList;
import java.util.List;

/**
 * 5689. Count Items Matching a Rule
 * User Accepted:2683
 * User Tried:2724
 * Total Accepted:2701
 * Total Submissions:2836
 * Difficulty:Easy
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 *
 * The ith item is said to match the rule if one of the following is true:
 *
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 *
 *
 *
 * Example 1:
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 * Example 2:
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * Output: 2
 * Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 */
public class CountItemsMatchingTheRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        List<String> ruleKeys = new ArrayList(){{add("type"); add("color");add("name");}};
        int idxToMatch = ruleKeys.indexOf(ruleKey);
        int cnt=0;
        for(List<String> item:items) {
            if(item.get(idxToMatch).equals(ruleValue))
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        //items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"

    }
}
