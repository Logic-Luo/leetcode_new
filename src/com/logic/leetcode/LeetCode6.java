package com.logic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author logic
 * @date 2019/7/9 9:47 AM
 * @since 1.0
 */
public class LeetCode6 {
    public static void main(String[] args) {
        String string = "PAYPALISHIRING";
        System.out.println(new Solution2().convert(string, 3));
    }


    private static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }

            List<StringBuilder> rows = new ArrayList<>();
            int length = s.length();
            for (int i = 0; i < Math.min(numRows, length); i++) {
                rows.add(new StringBuilder());
            }

            int curRow = 0;
            boolean goingDown = false;

            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) {
                    goingDown = !goingDown;
                }
                curRow += goingDown ? 1 : -1;
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }
            return result.toString();
        }
    }

    private static class Solution2 {
        public String convert(String s, int numRows) {
            if(numRows == 1) {
                return s;
            }

            StringBuilder result = new StringBuilder();
            int n = s.length();
            int cycleLen = 2 * numRows - 2;

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j + i < n; j += cycleLen) {
                    result.append(s.charAt(j + i));
                    if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                        result.append(s.charAt(j + cycleLen - i));
                    }
                }
            }
            return result.toString();
        }
    }
}
