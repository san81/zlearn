package com.san.amazon.trees;

import java.util.*;

public class CourseScheduleII {

    boolean isPossible = true;
    Stack<Integer> courses = new Stack<>();
    Map<Integer, List<Integer>> adjMat = new HashMap<>();
    Map<Integer, Integer> visited = new HashMap<>();
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    public void topologicalSortUtil(int vertex) {

        if(!isPossible){
            return;
        }

        visited.put(vertex, GRAY);
        for(Integer adjVertex: adjMat.get(vertex)) {
            if(visited.get(adjVertex)==WHITE) {
                topologicalSortUtil(adjVertex);
            }else if(visited.get(adjVertex)==GRAY) {
                //There is a cycle in the course dependency
                isPossible = false;
            }
        }

        visited.put(vertex, BLACK);
        courses.add(vertex);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {


        for(int i=0;i<numCourses;i++){
            adjMat.put(i, new ArrayList<>());
            visited.put(i, WHITE);
        }
        for(int[] dep:prerequisites) {
            adjMat.get(dep[0]).add(dep[1]);
        }
        for(int i=0;i<numCourses; i++){
            if(visited.get(i)==WHITE)
                topologicalSortUtil(i);
        }
        if(!isPossible) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i=numCourses-1;i>=0;i--){
            result[i] = courses.pop();
        }
        return result;
    }

    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{0,1}};

//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1,0}};

        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        int[] order = new CourseScheduleII().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}
