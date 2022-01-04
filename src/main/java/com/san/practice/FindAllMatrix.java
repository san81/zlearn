package com.san.practice;

import java.io.*;
import java.util.*;

/**
 * Created by santhoshgandhe on 4/24/19.
 */




// Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

// The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

// image1 = [
//   [0, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 0, 1, 0, 0, 0, 1],
//   [1, 0, 1, 1, 1, 1, 1],
//   [1, 0, 1, 0, 0, 1, 1],
//   [1, 1, 1, 0, 0, 1, 1],
//   [1, 1, 1, 1, 1, 1, 0],
// ]

// Sample output variations (only one is necessary):

// findRectangles(image1) =>
//   // (using top-left and bottom-right):
//   [
//     [[0,0],[0,0]],
//     [[2,3],[3,5]],
//     [[3,1],[5,1]],
//     [[5,3],[6,4]],
//     [[7,6],[7,6]],
//   ]
//   // (using top-left and width/height):
//   [
//     [[0,0],[1,1]],
//     [[2,3],[3,2]],
//     [[3,1],[1,3]],
//     [[5,3],[2,2]],
//     [[7,6],[1,1]],
//   ]

// Other test cases:

// image2 = [
//   [0],
// ]

// findRectangles(image2) =>
//   // (using top-left and bottom-right):
//   [
//     [[0,0],[0,0]],
//   ]

//   // (using top-left and width/height):
//   [
//     [[0,0],[1,1]],
//   ]

// image3 = [
//   [1],
// ]

// findRectangles(image3) => []



class FindAllMatrix {
    public static void main(String[] args) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };
/*
        Point[] points = findzeromatrix(image1);
        System.out.println(points[0]+" "+points[1]);

        points = findzeromatrix(image2);
        System.out.println(points[0]+" "+points[1]);

        points = findzeromatrix(image3);
        System.out.println(points[0]+" "+points[1]);*/

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        public String toString(){
            return "X: "+x+", Y:"+y;
        }

        public boolean equals(Point otherP){
            return x==otherP.x && y==otherP.y;
        }

        public int hashcode(){
            return (x*17)+(y*31);
        }
    }


    public static Map<Point,Point> findzeromatrix(int[][] mat){

        Point topLeft=null;
        Point bottomRight=null;

        Map<Point,Point> topLefts = new HashMap<Point,Point>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    //found the top left at i,j
                    //Make sure its surrounding are no zero then we can assume that it is a topLeft of a new matrix
                    if(mat[i-1][j]==0 && mat[i+1][j]==0 && mat[i][j+1]==0 && mat[i][j-1]==0){
                    }
                    topLeft=new Point(i,j);
                    topLefts.get(topLeft);
                    bottomRight=findBottomRight(mat, topLeft);
                }else{
                    bottomRight=new Point(i,j);
                }

            }
        }
        return topLefts;

    }


    public static Point findBottomRight(int[][] mat, Point p){

        Point bottomRight = null;

        for(int i=p.x;i<mat.length;i++){
            for(int j=p.y;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    bottomRight=new Point(i,j);
                }else{
                    break;
                }
            }
        }
        return bottomRight;
    }


}





