package com.logic.leetcode;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * <p>
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * @author logic
 * @date 2019-08-13 14:33
 * @since 1.0
 */
public class LeetCode232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }

    private static class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!outStack.isEmpty()) {
               return outStack.pop();
            }
            if (!inStack.isEmpty()) {
                transData();
                return outStack.pop();
            }
            return -1;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }
            if (!inStack.isEmpty()) {
                transData();
                return outStack.peek();
            }
            return -1;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        /**
         * 将入栈里面的数据写入到出栈里面
         */
        private void transData() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
