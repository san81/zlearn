package com.san.amazon.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are monitoring the building density in a district of houses. The district is represented as a number line, where a house can be built at each numbered point on the line if at least one of the neighboring points is not occupied. Initially, there are no houses in the district.
 *
 * You are given queries, an array of integers representing the locations of new houses in the order in which they will be built. After each house is built, your task is to find the longest segment of contiguous houses in the district.
 *
 * Return an array of integers representing the longest segment of contiguous houses after each respective house from queries is built.
 *
 * NOTE: It's guaranteed that all of the house locations in queries are unique and no house was built at a point with existing houses on both left and right adjacent points.
 *
 * Assume that array indices are 0-based.
 *
 * Example
 * For queries = [2, 1, 3], the output should be solution(queries) = [1, 2, 3].
 *
 * Let's look at what happens at each step:
 * After queries[0] = 2, there is only one house in the district (at 2), so the answer is 1.
 * After queries[1] = 1, there are two houses in the district (at 1 and 2). This means there is a segment of 2 contiguous houses, so the answer is 2.
 * After queries[2] = 3, there are three houses in the district (at 1, 2, and 3). This means there is a segment of 3 contiguous houses, so the answer is 3.
 * So the final answer is [1, 2, 3].
 *
 * For queries = [1, 3, 0, 4], the output should be solution(queries) = [1, 1, 2, 2].
 * Expand to see the example video.
 * Note: If you are not able to see the video, use this link to access it.
 * Let's look at what happens at each step:
 * After queries[0] = 1, there is only one house in the district (at 1), so the answer is 1.
 * After queries[1] = 3, there are two houses in the district (at 1 and 3). These two houses are not contiguous, so the answer is still 1.
 * After queries[2] = 0, there are three houses in the district (at 0, 1, and 3). This means there is a segment of 2 contiguous houses, so the answer is 2.
 * Ater queries[2] = 4, there are two segments of 2 contiguous houses, so the answer is still 2.
 * So the final answer is [1, 1, 2, 2].
 *
 *
 * Input/Output
 * [execution time limit] 4 seconds (py3)
 * [memory limit] 1 GB
 * [input] array.integer queries
 * An array of integers representing the requested house building coordinates.
 *
 * Guaranteed constraints:
 *
 * 1 ≤ queries.length ≤ 105,
 * -109 ≤ queries[i] ≤ 109.
 *
 * [output] array.integer
 * An array of integers representing the longest segment of contiguous houses after each build.
 */

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
