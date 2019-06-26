package com.logic.leetcode;

/**
 * 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 * <p>
 * <p>
 * Note:
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * If this function is called many times, how would you optimize it?¬
 *
 * @author logic
 * @date 2019/6/26 1:06 PM
 * @since 1.0
 */
public class LeetCode190 {
    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(new Solution().reverseBits(43261596)));
    }

    private static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            int mode;
            int i = 0;
            while (i < 32) {
                mode = n & 1;
                result = (result << 1) | mode;
                n = n >> 1;
            }

            return result;
        }
    }
}
