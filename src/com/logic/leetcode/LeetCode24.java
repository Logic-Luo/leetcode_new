package com.logic.leetcode;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author logic
 * @date 2019-08-09 13:04
 * @since 1.0
 */
public class LeetCode24 {

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
//        p4.next = p5;
        ListNode listNode = new Solution().swapPairs(p1);

        System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public ListNode swapPairs(ListNode head) {

            ListNode p = head;
            ListNode next;
            ListNode pre = null;

            while (p != null && p.next != null) {
                next = p.next.next;
                if (pre == null) {
                    head = p.next;
                } else {
                    pre.next = p.next;
                }
                p.next.next = p;
                p.next = next;
                pre = p;
                p = next;
            }
            return head;
        }
    }
}
