package com.logic.leetcode;

import java.util.List;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author logic
 * @date 2019-08-09 10:30
 * @since 1.0
 */
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = new Solution2().reverseList(node1);
        System.out.println(listNode);
    }

    private static class Solution {
        public ListNode reverseList(ListNode head) {

            ListNode p = head;
            head = null;
            ListNode q = null;

            while (p != null) {
                q = p;
                p = p.next;
                q.next = head;
                head = q;
            }
            return head;
        }
    }

    private static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;
            ListNode temp = reverseList(next);
            next.next = head;
            head.next = null;
            return temp;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
