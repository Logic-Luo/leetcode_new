package com.logic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author logic
 * @date 2019/6/24 1:41 PM
 * @since 1.0
 */
public class LeetCode18 {
    public static void main(String[] args) {
        int nums[] = new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2};
        int target = -9;
        System.out.println(new Solution().fourSum(nums, target));
        System.out.println(new Solution1().fourSum(nums, target));
    }

    /**
     * 抄来的，可以变动下，看着比较繁琐
     */
    private static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;

            if (nums == null || length < 4) {
                return result;
            }

            Arrays.sort(nums);

            int max = nums[length - 1];
            //如果所有的数据都不合适的话，就返回空
            if (4 * nums[0] > target || 4 * max < target) {
                return result;
            }

            int i, z;
            for (i = 0; i < length; i++) {
                z = nums[i];
                if (i > 0 && z == nums[i - 1]) {
                    continue;
                }

                //z 太小
                if (z + 3 * max < target) {
                    continue;
                }

                //z太大
                if (4 * z > target) {
                    break;
                }

                //添加最后一个元素
                if (4 * z == target) {
                    if (i + 3 < length && nums[i + 3] == z) {
                        result.add(Arrays.asList(z, z, z, z));
                    }
                    break;
                }
                threeSumForFourSum(nums, target - z, i + 1, length - 1, result, z);
            }


            return result;
        }

        public void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> result, int z1) {
            //如果数组中剩余的数少于数的个数
            if (low + 1 >= high) {
                return;
            }

            int max = nums[high];
            if (3 * nums[low] > target || 3 * max < target) {
                return;
            }

            int i, z;
            for (i = low; i < high - 1; i++) {
                z = nums[i];

                if ((i > low && z == nums[i - 1])) {
                    continue;
                }

                if (z + 2 * max < target) {
                    continue;
                }

                if (3 * z > target) {
                    break;
                }

                if (3 * z == target) {
                    if (i + 1 < high && nums[i + 2] == z) {
                        result.add(Arrays.asList(z1, z, z, z));
                    }
                    break;
                }
                twoSumForFourSum(nums, target - z, i + 1, high, result, z1, z);
            }
        }

        public void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> result, int z1, int z2) {
            if (low >= high) {
                return;
            }

            if (2 * nums[low] > target || 2 * nums[high] < target) {
                return;
            }

            int i = low;
            int j = high;
            int sum, x;
            while (i < j) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    result.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                    x = nums[i];
                    while (++i < j && x == nums[i]) {
                    }

                    while (i < --j && x == nums[j]) {

                    }
                }

                if (sum < target) {
                    i++;
                }
                if (sum > target) {
                    j--;
                }
            }
            return;
        }
    }

    /**
     * 一种递归方法，将范围逐渐缩小
     */
    private static class Solution1 {
        int len = 0;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            len = nums.length;
            Arrays.sort(nums);
            return kSum(nums, target, 4, 0);
        }

        private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

            if (index >= len) {
                return result;
            }

            if (k == 2) {
                int i = index;
                int j = len - 1;

                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j])));
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j - 1] == nums[j]) {
                            j--;
                        }

                        i++;
                        j--;
                    } else if (nums[i] + nums[j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            } else {
                for (int i = index; i < len - k + 1; i++) {
                    ArrayList<List<Integer>> tempResult = kSum(nums, target - nums[i], k - 1, i + 1);
                    if (tempResult != null) {
                        for (List<Integer> t : tempResult) {
                            t.add(0, nums[i]);
                        }
                        result.addAll(tempResult);
                    }
                    while (i < len - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
            return result;
        }
    }
}
