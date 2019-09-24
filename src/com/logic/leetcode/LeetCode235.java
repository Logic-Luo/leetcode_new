package com.logic.leetcode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 *
 * @author logic
 * @date 2019-09-06 17:44
 * @since 1.0
 */
public class LeetCode235 {
    public static void main(String[] args) {

        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node6.left = node2;
        node6.right = node8;

        node2.left = node0;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;

        node8.left = node7;
        node8.right = node9;

        System.out.println(new Solution().lowestCommonAncestor(node6, node3, node5).val);

    }

    private static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }

            return findCommon(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
        }

        private TreeNode findCommon(TreeNode root, int min, int max) {
            if (root == null) {
                return null;
            }

            //判断p或者q是不是父子关系
            if (root.val >= min && root.val <= max) {
                return root;
            }

            if (root.left != null && root.val > max) {
                return findCommon(root.left, min, max);
            }

            if (root.right != null && root.val < min) {
                return findCommon(root.right, min, max);
            }
            return null;
        }
    }

    public static class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //说明都比root大或者都比root小，只要是一小一大，当前节点就是公共祖先节点了
            while ((root.val - p.val) * (root.val - q.val) > 0) {
                //都比当前节点大或者小的时候，用p、q那个节点比都可以
                root = root.val > p.val ? root.left : root.right;
            }
            return root;
        }
    }
}
