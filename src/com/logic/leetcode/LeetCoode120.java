package com.logic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @author logic
 * @date 2019-08-21 13:01
 * @since 1.0
 */
public class LeetCoode120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> level0 = new ArrayList<>();
        level0.add(2);

        List<Integer> level1 = new ArrayList<>();
        level1.add(3);
        level1.add(4);
        List<Integer> level2 = new ArrayList<>();
        level2.add(6);
        level2.add(5);
        level2.add(7);
        List<Integer> level3 = new ArrayList<>();
        level3.add(4);
        level3.add(1);
        level3.add(8);
        level3.add(3);

        triangle.add(level0);
        triangle.add(level1);
        triangle.add(level2);
        triangle.add(level3);

        System.out.println(new Solution().minimumTotal(triangle));
    }

    /**
     * 使用递归, 在LeetCode上会超时
     */
    private static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }

            return recursion(triangle, 0, 0);
        }

        private int recursion(List<List<Integer>> triangle, int i, int level) {
            //终结条件
            if (level == triangle.size() - 1) {
                return triangle.get(level).get(i);
            }

            //递归方程
            int left = recursion(triangle, i, level + 1);
            int right = Integer.MAX_VALUE;
            if (i + 1 < triangle.get(level + 1).size()) {
                right = recursion(triangle, i + 1, level + 1);
            }

            return left > right ? right + triangle.get(level).get(i) : left + triangle.get(level).get(i);
        }
    }

    /**
     * 使用动态规划
     */
    private static class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }

            int size = triangle.size();
            for (int i = size - 2; i >= 0; i--) {
                List<Integer> bottomLevel = triangle.get(i + 1);
                List<Integer> currentLevel = triangle.get(i);

                int length = currentLevel.size();
                for (int j = 0; j < length; j++) {
                    if (bottomLevel.get(j) > bottomLevel.get(j + 1)) {
                        currentLevel.set(j, currentLevel.get(j) + bottomLevel.get(j + 1));
                    } else {
                        currentLevel.set(j, currentLevel.get(j) + bottomLevel.get(j));
                    }
                }
            }

            return triangle.get(0).get(0);
        }
    }
}
