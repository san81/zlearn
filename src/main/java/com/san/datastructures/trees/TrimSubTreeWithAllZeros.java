package com.san.datastructures.trees;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// // /*
// // You’re given a binary tree where each node stores a value 0 or 1.

// // Modify the tree in place so that any node is removed if its entire subtree contains only 0s.

// // If a node or any of its descendants contains a 1, it must remain in the tree.
// // */


class TreeNodeOCI {
    int val;
    TreeNodeOCI left;
    TreeNodeOCI right;

    public TreeNodeOCI(int val, TreeNodeOCI left, TreeNodeOCI right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printNode(TreeNodeOCI node) {
        if (node == null) return;
        System.out.println(node.val + " ");
        printNode(node.left);
        printNode(node.right);
    }

}

public class TrimSubTreeWithAllZeros {

    public static int postOrderTraversal(TreeNodeOCI root) {
        if (root == null) return 0;


        int leftOneCount = TrimSubTreeWithAllZeros.postOrderTraversal(root.left);
        int rightOneCount = TrimSubTreeWithAllZeros.postOrderTraversal(root.right);

        if (leftOneCount == 0) {
            //that means we got all zeros in the left subtree. There are no 1's
            root.left = null;

        }

        if (rightOneCount == 0) {
            root.right = null;
        }

        if (root.val == 1) {
            return 1 + leftOneCount + rightOneCount;
        } else {
            return leftOneCount + rightOneCount;
        }
    }


    static void trimZeroValSubTrees(TreeNodeOCI root) {
        postOrderTraversal(root);


    }

    public static void main(String[] args) {
        //TreeNode l1 = new TreeNode(1, null, null);
        //TreeNode r1 = new TreeNode(0, null, null);
        TreeNodeOCI r = new TreeNodeOCI(0, null, null);

        TreeNodeOCI.printNode(r);

        trimZeroValSubTrees(r);
        System.out.println("After tirmming");
        TreeNodeOCI.printNode(r);

    }
}

