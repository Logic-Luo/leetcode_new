package com.logic.leetcode;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * @author logic
 * @date 2019/7/3 9:19 AM
 * @since 1.0
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome(121));
    }

    private static class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            int start = 0;
            int end = s.length() - 1;
            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    private static class Solution2 {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            //数字反向，得出一个数，看看是否与原来的数相等
            int tempx = x;
            int result = 0;
            while (tempx != 0) {
                result = tempx % 10 + result * 10;
                tempx = tempx / 10;
                if (tempx == result) {
                    return true;
                }
            }
            return result == x;
        }
    }
}
