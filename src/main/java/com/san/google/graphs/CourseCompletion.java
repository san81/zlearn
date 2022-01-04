package com.san.google.graphs;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 */
public class CourseCompletion {
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
}
