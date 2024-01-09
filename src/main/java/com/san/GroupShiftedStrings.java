package com.san;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

  public int convertToNum(String str) {
    char[] charArr = str.toCharArray();
    String nChar = "";
    char lastChar = charArr[0];
    for (int i=1;i<charArr.length;i++) {
      nChar += (charArr[i] - lastChar);
      lastChar = charArr[i];
    }
    return Integer.parseInt(nChar);
  }

  public List<List<String>> groupStrings(String[] strings) {
    int[] nums = new int[strings.length];
    int i = 0;
    Map<Integer, List<String>> ans = new HashMap<>();
    for (String str : strings) {
      int cNum = convertToNum(str);
      List<String> curList = ans.getOrDefault(cNum, new ArrayList<>());
      curList.add(strings[i]);
      ans.put(cNum, curList);
      nums[i++] = cNum;
    }
    System.out.println(Arrays.toString(nums));
    List<List<String>> finalAns = new ArrayList<>();
    for (Map.Entry<Integer, List<String>> keyval : ans.entrySet()) {
      finalAns.add(keyval.getValue());
    }
    return finalAns;
  }

  public static void main(String[] args) {
    GroupShiftedStrings gss = new GroupShiftedStrings();
    String[] strings = new String[]{"abc","bcd","acef","xyz","az","ba","a","z"};
    List<List<String>> lists = gss.groupStrings(strings);
    System.out.println(lists);
  }
}
