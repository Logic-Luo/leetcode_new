package com.logic.leetcode;

/**
 * 509. Fibonacci Number
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 * <p>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 * <p>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 ≤ N ≤ 30.
 *
 * @author logic
 * @date 2019-08-21 12:45
 * @since 1.0
 */
public class LeetCode509 {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(10));
    }

    /**
     * 动态规划版本
     */
    private static class Solution2 {
        public int fib(int N) {
            if (N <= 1) {
                return N;
            }

            int[] fibArray = new int[N + 1];
            fibArray[0] = 0;
            fibArray[1] = 1;

            for (int i = 2; i <= N; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            }
            return fibArray[N];
        }
    }


    /**
     * 动态规划简化版
     */
    private static class Solution {
        public int fib(int N) {
            if (N == 0) {
                return 0;
            }

            if (N == 1) {
                return 1;
            }

            int n_1 = 1;
            int n_2 = 0;
            int result = 0;
            for (int i = 2; i <= N; i++) {
                result = n_2 + n_1;
                n_2 = n_1;
                n_1 = result;
            }
            return result;
        }
    }


    /**
     * 递归
     */
    private static class Solution1 {
        public int fib(int N) {
            if (N == 1) {
                return 1;
            }

            if (N == 0) {
                return 0;
            }

            return fib(N - 1) + fib(N - 2);
        }
    }
}
