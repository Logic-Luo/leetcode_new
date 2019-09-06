package com.logic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @author logic
 * @date 2019-09-06 09:11
 * @since 1.0
 */
public class LeetCode98 {

    public static void main(String[] args) {
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);
//        node2.left = node1;
//        node2.right = node3;
//        System.out.println(new Solution().isValidBST(node2));

        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);

        node5.left = node1;
        node5.right = node4;
        node4.left = node3;
        node4.right = node6;
        System.out.println(new Solution().isValidBST(node5));
    }

    private static class Solution {
        public boolean isValidBST(TreeNode root) {
            List<Integer> traverseResult = new ArrayList<>();
            inOrderTraverse(traverseResult, root);

            int size = traverseResult.size();
            for (int i = 0; i < size - 1; i++) {
                if (traverseResult.get(i) > traverseResult.get(i + 1)) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 递归中序遍历
         *
         * @param traverseResult 遍历的结果放到List中
         * @param root           根节点
         */
        private void inOrderTraverse(List<Integer> traverseResult, TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                inOrderTraverse(traverseResult, root.left);
            }

            traverseResult.add(root.val);
            if (root.right != null) {
                inOrderTraverse(traverseResult, root.right);
            }
        }

    }
}
