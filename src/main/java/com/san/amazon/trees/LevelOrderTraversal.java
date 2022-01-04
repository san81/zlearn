package com.san.amazon.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(null!=currentNode.left){
                    queue.add(currentNode.left);
                }
                if(null!=currentNode.right){
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
