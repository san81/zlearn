package com.san.amazon.trees;


public class LowestCommonAncestor {

    TreeNode ansNode;

    public boolean inOrderTraversal(TreeNode node, TreeNode p, TreeNode q) {
        if(null==node) return false;

        int left = inOrderTraversal(node.left, p, q) ? 1: 0;
        int right = inOrderTraversal(node.right, p, q) ? 1: 0;

        int mid = (node==p || node == q)? 1: 0;

        if(mid + left + right >= 2) {
            ansNode = node;
        }
        return (left+right+mid) > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inOrderTraversal(root, p, q);
        return ansNode;
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
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(node3, node5, node1));
    }
}
