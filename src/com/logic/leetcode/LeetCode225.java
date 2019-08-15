package com.logic.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * @author logic
 * @date 2019-08-14 11:04
 * @since 1.0
 */
public class LeetCode225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }

    private static class MyStack {
        LinkedList<Integer> queue1 = null;
        LinkedList<Integer> queue2 = null;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue2.add(x);
            } else {
                queue1.add(x);
            }

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            //这个时候需要将第二个队列中的数据转移到第一个队列，并剩下一个弹出
            if (queue1.isEmpty()) {
                return transDataAndRemove(queue2, queue1);
            } else {
                return transDataAndRemove(queue1, queue2);
            }
        }

        /** Get the top element. */
        public int top() {
            //这个时候需要将第二个队列中的数据转移到第一个队列，并剩下一个弹出
            if (queue1.isEmpty()) {
                return transDataAndReturnLast(queue2, queue1);
            } else {
                return transDataAndReturnLast(queue1, queue2);
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        private int transDataAndRemove(LinkedList<Integer> list1, LinkedList<Integer> list2) {
            while (list1.size() > 1) {
                list2.add(list1.removeFirst());
            }
            return list1.removeFirst();
        }

        private int transDataAndReturnLast(LinkedList<Integer> list1, LinkedList<Integer> list2) {
            while (list1.size() > 1) {
                list2.add(list1.removeFirst());
            }
            int integer = list1.removeFirst();

            list2.add(integer);
            return integer;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
