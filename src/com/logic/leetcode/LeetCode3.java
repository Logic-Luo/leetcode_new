package com.logic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author logic
 * @date 2019/6/28 12:40 PM
 * @since 1.0
 */
public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
    }


    /**
     * 遍历的方式
     */
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int maxLength = 0;
            int tempMax = 0;
            int length = s.length();
            int start = 0;
            for (int i = 0; i < length; i++) {
                int tempStart = start;
                for (int j = tempStart; j < i; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        start = j + 1;
                    }
                }

                tempMax = i - start + 1;

                if (tempMax > maxLength) {
                    maxLength = tempMax;
                }
            }
            return maxLength;
        }
    }

    /**
     * 滑动窗口的方式 pwwkew
     */
    private static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int maxLenth = 0;
            int left = 0;
            int right = 0;
            int length = s.length();

            Set<Character> set = new HashSet<>();
            while (right < length) {
                char c = s.charAt(right);
                if (set.add(c)) {
                    right ++;
                    maxLenth = Math.max(maxLenth, right - left);
                } else {
                    set.remove(s.charAt(left ++));

                }
            }

            return maxLenth;
        }
    }
}
