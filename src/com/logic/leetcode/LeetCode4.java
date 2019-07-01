package com.logic.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author logic
 * @date 2019/6/30 4:41 PM
 * @since 1.0
 */
public class LeetCode4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                } else {
                    nums[k] = nums2[j];
                    j++;
                }
                k++;
            }

            while (j < nums2.length) {
                nums[k++] = nums2[j++];
            }

            while (i < nums1.length) {
                nums[k++] = nums1[i++];
            }

            if ((nums1.length + nums2.length) % 2 == 0) {
                return (nums[(nums1.length + nums2.length) / 2] + nums[(nums1.length + nums2.length) / 2 - 1]) / 2.0;
            } else {
                return nums[(nums1.length + nums2.length) / 2] * 1.0;
            }
        }
    }
}
