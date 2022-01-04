package com.san.amazon.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagTraversal {
    List<List<Integer>>  result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(null==root){
            return result;
        }
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode node, int level) {
        if(result.size() == level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);


        if(level%2==0) {
            if(node.right!=null) {
                helper(node.right, level+1);
            }
            if(node.left!=null) {
                helper(node.left, level+1);
            }
        }else{
            if(node.left!=null) {
                helper(node.left, level+1);
            }
            if(node.right!=null) {
                helper(node.right, level+1);
            }
        }
    }
}
