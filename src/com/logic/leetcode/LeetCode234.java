package com.logic.leetcode;

/**
 * 234. Palindrome Linked List
 *
 * @author logic
 * @date 2019/7/3 9:37 AM
 * @since 1.0
 */
public class LeetCode234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node11 = new ListNode(1);
        node1.next = node2;
//        node2.next = node11;

        System.out.println(new Solution().isPalindrome(node1));

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            //记录前面节点翻转后链表的头结点
            ListNode pre = null;

            //如果快速节点不为空，并且快速节点的下一个节点也不为空
            ListNode tempNode;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                tempNode = slow.next;
                slow.next = pre;
                pre = slow;
                slow = tempNode;
            }

            //1、单个节点的时候，不用处理，直接返回true
            //2、slow 每走一步，fast 走两步，如果下一次fast没有两步可以走，说明是奇数个节点，slow多走一步，否则不需要走
            if (fast != null) {
                slow = slow.next;
            }

            //两个链表反向对比查询
            while (pre != null && slow != null) {
                if (pre.val != slow.val) {
                    return false;
                }
                pre = pre.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
