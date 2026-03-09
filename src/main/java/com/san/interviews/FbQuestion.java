package com.san.interviews;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Build a Tree from the given String describing the structure.
 *
 * Given a string like below, construct a binary tree.
 * It is not a BST.
 * If there is only one child to a root node, it is Left child only.
 *
 * 	1 - 2 - - 3 - - 4 - 5 - - 6 - - 7 - - - 8
 *
 */

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class FbQuestion {

    public int extractNextNumber(String s, int idx) {
        int idxOfDashAfterCurrentDash = s.indexOf((int)'-', idx);
        if(idxOfDashAfterCurrentDash==-1) {
            //if this itself is the last digit
            idxOfDashAfterCurrentDash = s.length()-1;
        }
        String substring = s.substring(idx, idxOfDashAfterCurrentDash);
        System.out.println(substring);
        return Integer.parseInt(substring);
    }

    public int findDashCntFromGivenIdx(String s, int idx) {
        int cnt=0;
        while(idx<s.length() && s.charAt(idx)=='-') {
            cnt++;
            idx++;
        }
        return cnt;
    }

    public TreeNode buildTreeFromGivenString(String s) {
        TreeNode root = new TreeNode(Integer.parseInt(s.charAt(0)+""));
        int idx = 1;
        String dashes = "-";
        int digit = 0;
        int prevDashCnt = 0;
        TreeNode current = root;
        while(idx < s.length()) {
           int dashCnt = findDashCntFromGivenIdx(s, idx);
           idx += dashCnt;
           int nextDigit = extractNextNumber(s, idx);
           if(prevDashCnt==dashCnt) {
               //it is a right child
           }else if(prevDashCnt+1==dashCnt) {
               //it is a new level, left child
               current.left = new TreeNode(nextDigit);
           }
        }
        return root;
    }


    public static void main(String[] args) {
        String s ="1-2--3--4---5-6--7--8---9";
        System.out.println(Arrays.toString(s.split("^(?!-)[0-9-]+.*$")));

    }
}
