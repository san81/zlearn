package com.san;

import java.util.Stack;

class DFSTraversal {


  static class Node {
    String str;
    Node left;
    Node right;

    Node(String str, Node left, Node right) {
      this.str = str;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String ar[]){
    System.out.println(7%14);
  }
  public static void main_(String[] args) {
    Node l5 = new Node("l5", null, null);
    Node l4 = new Node("l4", l5, null);
    Node l2 = new Node("l2", null, null);
    Node l3 = new Node("l3", l4, null);
    Node l1 = new Node("l1", l2, l3);
    Node r3 = new Node("r3", null, null);
    Node r2 = new Node("r2", null, null);
    Node r1 = new Node("r1", r2, r3);
    Node root = new Node("root", l1, r1);
    dfsWithStack(root);
    System.out.println("----------------");
    inorder(root);
    System.out.println("----------------");
  }

  public static void inorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.str + " -> ");
    if (root.left != null) {
      inorder(root.left);
    }
    if (root.right != null) {
      inorder(root.right);
    }
  }

  public static void dfsWithStack(Node root) {
    Stack<Node> s = new Stack<>();
    s.push(root);
    while (!s.isEmpty()) {
      Node n = s.pop();
      System.out.print(n.str + " -> ");
      if (n.right != null) {
        s.push(n.right);
      }
      if (n.left != null) {
        s.push(n.left);
      }
    }
  }
}
