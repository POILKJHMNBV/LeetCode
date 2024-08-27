package com.example.string;

/**
 * <p>L7:整数反转</p>
 * <p>
 *     给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *     如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * </p>
 * @author zhenwu
 * @date 2024/8/27 21:00
 */
public class L7_Reverse {
    public static void main(String[] args) {

    }

    private static int reversePro(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
