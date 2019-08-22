package com.logic.leetcode;

/**
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * @author logic
 * @date 2019-08-22 18:59
 * @since 1.0
 */
public class LeetCode70 {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }

    /**
     * 动态规划
     */
    private static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            int beforeOne = 1;
            int beforeTwo = 2;

            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = beforeOne + beforeTwo;
                beforeOne = beforeTwo;
                beforeTwo = result;
            }
            return result;
        }
    }

    /**
     * 递归，会超时
     */
    private static class Solution1 {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
