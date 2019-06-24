package com.logic.leetcode;

import java.util.*;

/**
 * 653. Two Sum IV - Input is a BST
 * <p>
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 *
 * @author logic
 * @date 2019/6/23 9:30 PM
 * @since 1.0
 */

public class LeetCode653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用HashMap
     */
    public static class Solution {
        Map<Integer, Boolean> hashMap = new HashMap<>();
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }

            if (hashMap.containsKey(root.val)) {
                return true;
            }

            hashMap.put(k - root.val, true);

            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

    /**
     * 使用广度优先
     */
    public static class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            Set<Integer> valueSet = new HashSet<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode pop =  queue.remove();
                if (pop != null) {
                    if (valueSet.contains(k - pop.val)) {
                        return true;
                    } else {
                        valueSet.add(pop.val);
                        queue.add(pop.left);
                        queue.add(pop.right);
                    }
                }
            }
            return false;
        }
    }
}
