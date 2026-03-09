package com.san.amazon;

import java.util.Stack;

class ConstructBinaryTreeFromString {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;

        while (i < traversal.length()) {

            // 1️⃣ Count depth (count '-')
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // 2️⃣ Parse number
            int value = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(value);

            // 3️⃣ Fix stack to correct parent depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // 4️⃣ Attach to parent if exists
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            // 5️⃣ Push current node
            stack.push(node);
        }

        // Root is bottom of stack
        while (stack.size() > 1) stack.pop();
        return stack.peek();
    }
}
