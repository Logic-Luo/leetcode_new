package com.logic.leetcode;

/**
 * 7. Reverse Integer
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 *
 * @author logic
 * @date 2019/6/25 9:52 PM
 * @since 1.0
 */
public class LeetCode7 {
    public static void main(String[] args) {

        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution2().reverse(123));
    }

    /**
     * 比较直接
     */
    private static class Solution {
        public int reverse(int x) {
            int result = 0;
            int temp = 0;
            while (x != 0) {
                temp = result;
                result = result * 10 + x % 10;
                if (result / 10 != temp) {
                    return 0;
                }
                x = x / 10;
            }

            return result;
        }
    }

    private static class Solution2 {
        public int reverse(int x) {
            int result = 0;
            int mod = 0;
            while (x != 0) {
                mod = x % 10;
                //这种情况如果x是正数的话，防止上溢出
                if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && mod == 7)) {
                    return 0;
                }

                if ((result < Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && mod == -8)) {
                    return 0;
                }
                result = result * 10 + mod;
                x = x / 10;
            }
            return result;
        }
    }
}
