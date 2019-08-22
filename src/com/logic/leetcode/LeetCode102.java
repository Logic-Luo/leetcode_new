package com.logic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author logic
 * @date 2019-08-22 19:10
 * @since 1.0
 */
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(new Solution().levelOrder(node3));

    }

    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();

            List<TreeNode> treeNodeList = new ArrayList<>();
            treeNodeList.add(root);

            while (treeNodeList.size() != 0) {

                int size = treeNodeList.size();
                List<Integer> tempList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode remove = treeNodeList.remove(0);
                    tempList.add(remove.val);
                    if (remove.left != null) {
                        treeNodeList.add(remove.left);
                    }
                    if (remove.right != null) {
                        treeNodeList.add(remove.right);
                    }
                }

                result.add(tempList);
            }

            return result;
        }
    }
}
