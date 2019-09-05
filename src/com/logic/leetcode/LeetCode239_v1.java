package com.logic.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 *
 * @author logic
 * @date 2019-08-29 13:24
 * @since 1.0
 */
public class LeetCode239_v1 {
    public static void main(String[] args) {
        int[] num = new int[]{1,3,-1,-3,5,3,6,7};
        int[] num1 = new int[]{1,-1};
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(num, 3)));
    }

    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k <= 0) {
                return new int[0];
            }

            int[] result = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                //先把元素放到队列中
                queue.offer(i);

                //如果队列中的最大值小于当前值
                if (nums[queue.peek()] <= nums[i]) {
                    //把其余的元素出队，就剩下一个最大值
                    while (queue.size() != 1) {
                        queue.pop();
                    }
                } else {
                    //如果队列中的最大值大于当前值
                    if (queue.size() > k) {
                        //找出最大值，并将原来的元素出队
                        //先原来的最大值弹出去
                        queue.pop();
                        //在剩余的里面找最大值
                        int max = queue.peek();
                        for (int j = 0; j < queue.size(); j++) {
                            if (nums[queue.get(j)] >= nums[max]) {
                                max = queue.get(j);
                            }
                        }
                        //弹出最大值之前的元素
                        while (max != queue.peek()) {
                            queue.pop();
                        }
                    }
                }

                if (i >= k -1 ) {
                    result[i-k+1] = nums[queue.peek()];
                }
            }
            return result;
        }
    }
}
