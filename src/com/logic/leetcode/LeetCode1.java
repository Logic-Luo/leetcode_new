package com.logic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode1
 *
 * 1. Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author logic
 * @date 2019/6/23 6:58 PM
 * @since 1.0
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution1().twoSum(nums, target)));
        System.out.println(Arrays.toString(new Solution2().twoSum(nums, target)));
    }

    /**
     * 暴力破解方法
     */
    private static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 0) {
                return null;
            }

            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }

            return null;
        }
    }

    /**
     * 优化后的破解方法
     * 使用Map存储数据
     */
    private static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 0) {
                return null;
            }

            Map<Integer, Integer> numMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (numMap.containsKey(temp)) {
                    return new int[]{numMap.get(temp), i};
                } else {
                    numMap.put(nums[i], i);
                }
            }
            return new int[]{0, 0};
        }
    }
}