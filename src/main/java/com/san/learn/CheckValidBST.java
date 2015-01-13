
package com.san.learn;

public class CheckValidBST {


/*Welcome to Stypi!

Stypi is a realtime editor that allows multiple users to make changes to a single document at the same time. 
All you need to do is share the URL with others to begin collaborating!

This editor also supports programming languages that you can access by clicking on the "</>" button on the top left. 
For more information on how to use Stypi please click the FAQ link on the bottom left.

Hello.

        5
   3         8
 1   6     7   9
          4    
*/



static class Node {
    Node left;
    Node right;
    int data;
    
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    
    public Node(int data, Node left, Node right) {
        this.data=data;
        this.left=left;
        this.right=right;
    }
}




public static boolean isValidBST(Node root, int max, int min){
    boolean result=true;
    if(root.data > max || root.data < min){
        return  false;
    }
        if(root.left!=null){
            result= isValidBST(root.left, root.data, min);
        }
        if(result && root.right!=null) {
            result= isValidBST(root.right, max, root.data);
        }
    
    return result;
}

public static void main(String ar[]){
    //construct BST
    /*
     *          5
           3         8
         1   6     7   9
                  4 
     */
    
    Node leaf4 = new Node(4);
    Node leaf6 = new Node(6);
    Node leaf1 = new Node(1);
    Node leaf9 = new Node(9);
    Node leaf7 = new Node(7,leaf4,null);
    Node leaf8 = new Node(8,leaf7,leaf9);
    Node leaf3 = new Node(3, leaf1, leaf6);
    
    Node root = new Node(5,leaf3,leaf8);
    
    System.out.println(" Checking the validity of the BST "+isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
}


}
