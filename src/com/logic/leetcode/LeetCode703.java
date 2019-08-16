package com.logic.leetcode;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 * @author logic
 * @date 2019-08-16 09:43
 * @since 1.0
 */
public class LeetCode703 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest2 kthLargest = new KthLargest2(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 4
        System.out.println(kthLargest.add(10));   // returns 4
        System.out.println(kthLargest.add(9));   // returns 4
        System.out.println(kthLargest.add(4));   // returns 4
    }

    private static class KthLargest2 {
        private PriorityQueue<Integer> queue;
        private int k;

        public KthLargest2(int k, int[] nums) {
            queue = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > k) {
                queue.poll();
            }

            return queue.peek();
        }
    }

    private static class KthLargest {
        private PriorityQueue<Integer> queue;
        private int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                if (queue.size() == k) {
                    if (queue.peek() < num) {
                        queue.remove();
                        queue.add(num);
                    }
                } else {
                    queue.add(num);
                }
            }
        }

        public int add(int val) {
            if (queue.size() == k) {
                if (queue.peek() < val) {
                    queue.remove();
                    queue.add(val);
                }
            } else {
                queue.add(val);
            }

            return queue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
