package com.logic.leetcode;

/**
 * 输出工具类
 *
 * @author logic
 * @date 2019-08-12 20:45
 * @since 1.0
 */
public class PrintUtil {

    /**
     * 输出链表工具类
     *
     * @param head 头结点
     */
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
