package com.logic.leetcode;

import java.util.Arrays;

/**
 * LeetCode 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @author logic
 * @date 2019/6/23 8:47 PM
 * @since 1.0
 */
public class LeetCode167 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null || numbers.length <= 0) {
                return null;
            }

            int start = 0;
            int end = numbers.length - 1;
            while (start < end) {
                int temp = numbers[start] + numbers[end];
                if (temp == target) {
                    return new int[]{start + 1, end + 1};
                } else if (temp > target) {
                    end --;
                } else {
                    start ++;
                }
            }
            return null;
        }
    }
}