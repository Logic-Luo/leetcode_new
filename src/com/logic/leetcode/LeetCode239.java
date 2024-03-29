package com.logic.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author logic
 * @date 2019/7/11 9:58 AM
 * @since 1.0
 */
public class LeetCode239 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, 3)));
    }


    /**
     * 每次获取三个，然后在三个里面选
     */
    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }
            int resultLength = nums.length - k + 1;

            int[] result = new int[resultLength];
            int left = 0;
            int right = k - 1;
            int i = 0;
            while (right < nums.length) {
                int max = findMax(left++, right++, nums);
                result[i++] = max;
            }
            return result;
        }

        private int findMax(int left, int right, int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        }
    }

    private static class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return nums;
            }
            int length = nums.length;
            int[] result = new int[length - k + 1];
            LinkedList<Integer> dq = new LinkedList<>();

            for (int i = 0; i < length; i++) {
                if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                    dq.poll();
                }

                while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                    dq.pollLast();
                }

                dq.offer(i);

                if (i - k + 1 >= 0) {
                    result[i - k + 1] = nums[dq.peek()];
                }
            }
            return result;
        }
    }
}
