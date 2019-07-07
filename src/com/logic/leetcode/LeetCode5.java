package com.logic.leetcode;

/**
 * 5. Longest Palindromic Substring
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author logic
 * @date 2019/7/7 9:52 PM
 * @since 1.0
 */
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }

    private static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            int length = s.length();

            String paling = "";
            String temp1;
            for (int i = 0; i < length; i++) {
                //回文字符串字符个数为奇数
                temp1 = computePalindrome(s, 0, length - 1, i, i);
                if (temp1.length() > paling.length()) {
                    paling = temp1;
                }

                //回文字符串字符个数为偶数
                if (i >= 1) {
                    temp1 = computePalindrome(s, 0, length - 1, i-1, i);
                    if (temp1.length() > paling.length()) {
                        paling = temp1;
                    }
                }
            }
            return paling;
        }

        private String computePalindrome(String s, int start, int end, int low, int high) {
            while (low >= start && high <= end) {
                if (s.charAt(low) == s.charAt(high)) {
                    low--;
                    high++;
                } else {
                    break;
                }
            }
            return s.substring(++low, high);
        }
    }
}
