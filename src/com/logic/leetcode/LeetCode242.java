package com.logic.leetcode;

/**
 * 242. Valid Anagram
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author logic
 * @date 2019-08-16 11:41
 * @since 1.0
 */
public class LeetCode242 {
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("abc", "ca"));
    }

    private static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] sChar = new int[26];

            //将s字符串中的数据添加到数组中
            int sLength = s.length();
            for (int i = 0; i < sLength; i++) {
                sChar[s.charAt(i) - 'a']++;
            }

            //将t字符串中的数据添加到数组中
            int tLength = t.length();
            for (int j = 0; j < tLength; j++) {
                sChar[t.charAt(j) - 'a']--;
            }

            //比较并返回
            for (int i = 0; i < 26; i++) {
                if (sChar[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
