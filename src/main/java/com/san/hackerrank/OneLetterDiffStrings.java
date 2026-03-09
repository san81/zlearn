package com.san.hackerrank;
import org.junit.Assert;

import java.util.*;

class OneLetterDiffStrings {
    public static List<Integer> getRemovableIndices(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        List<Integer> res = new ArrayList<>();

        if (n1 != n2 + 1) {
            res.add(-1);
            return res;
        }

        int left = 0;
        while (left < n2 && str1.charAt(left) == str2.charAt(left)) {
            left++;
        }

        int r1 = n1 - 1;
        int r2 = n2 - 1;
        while (r2 >= 0 && str1.charAt(r1) == str2.charAt(r2)) {
            r1--;
            r2--;
        }


        for (int i = r1 ; i <= left; i++) {
            res.add(i);
        }

        if (res.isEmpty()) {
            res.add(-1);
            return res;
        }

        return res;
    }

    public static void main(String[] args) {
        Assert.assertEquals(Arrays.asList(3,4,5), OneLetterDiffStrings.getRemovableIndices("abdgggda", "abdggda"));
        Assert.assertEquals(Arrays.asList(-1), OneLetterDiffStrings.getRemovableIndices("mmgghh", "mfggh"));
    }
}