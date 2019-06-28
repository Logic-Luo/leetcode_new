package com.logic.leetcode;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author logic
 * @date 2019/6/27 1:27 PM
 * @since 1.0
 */
public class LeetCode2 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        ListNode listNode = new Solution().addTwoNumbers(new ListNode(5), new ListNode(5));

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode result = null;
            ListNode p3 = null;
            int carry = 0;

            int tempSum = 0;
            while ((p1 != null) || (p2 != null)) {
                if (p1 != null && p2 != null) {
                    tempSum = p1.val + p2.val + carry;
                    p1 = p1.next;
                    p2 = p2.next;
                } else if (p1 != null && p2 == null) {
                    tempSum = p1.val + carry;
                    p1 = p1.next;
                } else {
                    tempSum = p2.val + carry;
                    p2 = p2.next;
                }
                ListNode node = new ListNode(tempSum % 10);
                carry = tempSum / 10;
                if (result == null) {
                    result = node;
                }
                if (p3 == null) {
                    p3 = node;
                } else {
                    p3.next = node;
                    p3 = node;
                }
            }
            if (carry > 0) {
                p3.next = new ListNode(carry);
            }

            return result;
        }
    }
}
