package com.san.amazon.trees;

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
  public String toString(){
      return val+"";
  }
}
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode root, long min, long max) {
        if(min >= root.val || root.val >= max) {
            return false;
        }

        boolean isLeftValid = true;
        boolean isRightValid = true;

        if(null!= root.left)
            isLeftValid = isValidNode(root.left, min, root.val);

        if(null!=root.right)
            isRightValid = isValidNode(root.right, root.val, max);

        return isLeftValid && isRightValid;
    }

}
