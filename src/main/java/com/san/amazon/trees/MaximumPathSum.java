package com.san.amazon.trees;

public class MaximumPathSum {
    int maxSeen = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSeen;
    }

    public int maxGain(TreeNode node) {
        if(null==node) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int pathGain = node.val + leftGain + rightGain;

        maxSeen = Math.max(maxSeen, pathGain);

        return node.val + Math.max(leftGain, rightGain);
    }
}
