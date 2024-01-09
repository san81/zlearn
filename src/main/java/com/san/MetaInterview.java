package com.san;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class MetaInterview {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
    int[] arr = {5, 6, 0, 3, 23, 47, 15};
    arr = new int[]{2,1};
    arr = new int[]{7,6,5,4,3,2,1};
//    arr = new int[]{3,3,3,3,3,3,3,3,3};
    int k = 2;
    System.out.println(Arrays.toString(arr));
    int fourthMax = new MetaInterview().quickSelect(arr, 0, arr.length-1, k);
    System.out.printf("k=%d Max = %d", k, fourthMax);
    System.out.println(Arrays.toString(arr));
  }

  // [5,6,0,3,23,47,15]
  public int quickSelect(int[] arr, int start, int end, int k) {//

    if(start>end) {
      return arr[end];
    }

    if(start+1==end){
      if(arr[start]<arr[end]) {
        int tmp = arr[start];
        arr[start] =arr[end];
        arr[end] = tmp;
      }
      return arr[arr.length-k];
    }
    //handle the cas where array has only one element
    int pivot = start;  // 0
    int i=start+1, j=end; //1, 6
    while(i<j) {

      while(arr[i]>=arr[pivot] && i<end){
        i++;
      } //i=3

      while(arr[j]<arr[pivot] && j>0){
        j--;
      }  //j=3

      //swap a[i] with a[j]
      if(i<j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
      }


      // [5,3,0,6,23,47,15]
      System.out.println(Arrays.toString(arr));
    }


    //swap pivot with ith index
    int tmp=arr[pivot];
    arr[pivot] = arr[j];
    arr[j] = tmp;

    // [0,3,5,6,23,47,15]
    System.out.println(Arrays.toString(arr));
    System.out.printf("i=%d j=%d pivot=%d k=%d %n", i,j,pivot,k);

    if(j==k-1){
      //we found the answer
      return arr[j];
    }else if(j < (k-1)){
      //answer will be on the right side
      return quickSelect(arr, j+1, end, k);
    }else {
      //answer will be on the left side
      return quickSelect(arr, start, j-1, k);
    }
  }
}


// Your previous Plain Text content is preserved below:

// Welcome to Meta!

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you would like to use for your interview,
// simply choose it from the dropdown in the left bar.

// Enjoy your interview!

// * Given an array of elements find the kth largest value
// * Example [5,6,0,3,23,47,15]
//     * K=1 → 47
//     * K=2 → 23
//     * K=3 → 15




// * int findKthLargest(int[] arr , int k)


//    4
//    /              \
//    /                  \
//    2                     7
//    /      \              /      \
//    /          \          /          \
//    1           3         6           10
//
//
//    ------------------------------------------------------------
//    |                                                                          |
//    --->1 <-> 2 <-> 3 <-> 4 <-> 6 <-> 7 <->10 <-
//    |                                                                          |
//    ---------------------------------------------------------------

//Given a binary tree, convert it, in-place (i.e. don't allocate new Nodes), into a circular doubly linked list in the same order as an in-order traversal of the tree.


 /*   Node head = root;
    Node tail = root;
public Node inorder(Node root) {

    Node leftHalfdl = null;
    if(root.left!=null){
    leftHalfdl  = inorder(root.left);
    }

    Node rightHalfdl = null;
    if(root.right!=null){
    rightHalfdl = inorder(root.right);
    }

    //print the root element
    root.left = leftHalfdl;
    if(leftHalfdl!=null) {
    leftHalfdl.right = root;
    }

    if(head==null) {
    head = root;
    }

    root.right = rightHalfdl;
    if(rightHalfdl!=null) {
    rightHalfdl.left = root;
    }

    return root;
    }


*/
