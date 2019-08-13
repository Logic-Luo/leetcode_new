package com.logic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author logic
 * @date 2019-08-13 09:45
 * @since 1.0
 */
public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}"));
    }

    private static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            //初始化一个Map
            Map<Character, Character> map = new HashMap<>(3);
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');

            Stack<Character> stack = new Stack<>();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                //判断是否是左括号
                if (map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    Character character = map.get(pop);
                    if (character.compareTo(c) != 0) {
                        return false;
                    }
                }
            }

            return stack.empty();
        }
    }

    private static class Solution2 {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
