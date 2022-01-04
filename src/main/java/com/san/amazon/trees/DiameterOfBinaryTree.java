package com.san.amazon.trees;

public class DiameterOfBinaryTree {

    int maxPathSize = 0;
    public int longestPath(TreeNode node){
        if(node==null) return 0;
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        int pathUntilThisNode = leftPath + rightPath + 1;
        if(maxPathSize<pathUntilThisNode){
            maxPathSize = pathUntilThisNode;
        }
        return leftPath > rightPath?leftPath+1:rightPath+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return maxPathSize-1;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode node3 = new TreeNode(3, node5, node1);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node3));
    }
}
