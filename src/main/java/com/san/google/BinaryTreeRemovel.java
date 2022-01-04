package com.san.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * Example 2:
 *
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 */



 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class BinaryTreeRemovel {

//     public List<TreeNode> levelOrder(TreeNode root, int[] to_delete) {
//         Set<Integer> toDelete = new HashSet<>();
//         List<TreeNode> childs = new ArrayList<>();
//         childs.add(root);
//         List<Integer> traversal = new ArrayList<Integer>();
//         List<TreeNode> answer = new ArrayList<>();
//
//         for(int ele:to_delete) {
//             toDelete.add(ele);
//         }
//         if(!toDelete.contains(root.val)){
//             answer.add(root);
//         }
//         while(childs.size()>0){
//             int n = childs.size();
//             for(int i=0;i<n;i++){
//                 TreeNode currentNode = childs.get(0);
//                 if(toDelete.contains(currentNode.val)){
//                     traversal.add(-1);
//                     if(currentNode.left!=null) answer.add(currentNode.left);
//                     if(currentNode.right!=null) answer.add(currentNode.right);
//                 }else {
//                     traversal.add(currentNode.val);
//                     if(currentNode.left!=null) childs.add(currentNode.left);
//                     if(currentNode.right!=null) childs.add(currentNode.right);
//                 }
//
//                 childs.remove(0);
//             }
//         }
//         System.out.println(traversal);
//         return answer;
//     }

    public void inOrder(TreeNode root, Set<Integer> toDelete, List<TreeNode> answer, TreeNode parent, boolean isLeft) {

        if(root==null) return;;

        if(root.left!=null) {
            if(toDelete.contains(root.val) && !toDelete.contains(root.left.val))
                answer.add(root.left);
            inOrder(root.left, toDelete, answer, root, true);
        }

        if(root.right!=null) {
            if(toDelete.contains(root.val) && !toDelete.contains(root.right.val))
                answer.add(root.right);
            inOrder(root.right, toDelete, answer, root, false);
        }

        if(toDelete.contains(root.val) && parent!=null){

            if(isLeft)
                parent.left = null;
            else
                parent.right = null;
        }

    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for(int ele:to_delete) {
             toDelete.add(ele);
         }
        List<TreeNode> answer = new ArrayList<>();
        inOrder(root, toDelete, answer, null, true);
        if(!toDelete.contains(root.val)) {
            answer.add(root);
        }
//        inOrder(root.left, toDelete, answer, root, true);
//        inOrder(root.right, toDelete, answer, root, false);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
         TreeNode n4 =new TreeNode(4);
         TreeNode n5 = new TreeNode(5);
         TreeNode n7 = new TreeNode(7);
         TreeNode n6 = new TreeNode(6);
         TreeNode n3 = new TreeNode(3, n6, null);
         TreeNode n2 = new TreeNode(2);
         TreeNode n1 = new TreeNode(1, n2, n3);
        //int[] root = new int[]{1,2,3,4,5,6,7};
        int[] to_delete = new int[]{2, 1};
        System.out.println(new BinaryTreeRemovel().delNodes(n1, to_delete));
    }

}
