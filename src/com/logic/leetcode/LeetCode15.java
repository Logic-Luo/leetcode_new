package com.logic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author logic
 * @date 2019/6/24 12:54 PM
 * @since 1.0
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }

    /**
     * 首先排序，然后再用二分法进行查找，
     */
    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return result;
            }
            //利用快排排序
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int start = i + 1;
                    int end = nums.length - 1;
                    int sum = 0 - nums[i];
                    while (start < end) {
                        int tempSum = nums[start] + nums[end];
                        if (tempSum == sum) {
                            result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                            while (start < end && nums[end] == nums[--end]) {
                            }

                            while (start < end && nums[start] == nums[++start]) {
                            }
                        } else if (tempSum > sum) {
                            while (start < end && nums[end] == nums[--end]) {
                            }
                        } else {
                            while (start < end && nums[start] == nums[++start]) {
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}