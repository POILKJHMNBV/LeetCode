package com.example.bit;

/**
 * <p>L371:两整数之和</p>
 * <p>给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。</p>
 * @author zhenwu
 * @date 2025/1/9 21:37
 */
public class L371_GetSum {
    public static void main(String[] args) {

    }

    private static int getSum(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
