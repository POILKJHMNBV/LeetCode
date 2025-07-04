package com.example.bit;

/**
 * <p>L2429:最小异或</p>
 * @author zhenwu
 * @date 2025/7/4 20:43
 */
public class L2429_MinimizeXor {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(|log num1 - log num2|)
     * 空间复杂度: O(1)
     */
    private static int minimizeXor(int num1, int num2) {
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        for (; c2 < c1; c2++) num1 &= num1 - 1; // 最低的 1 变成 0
        for (; c2 > c1; c2--) num1 |= num1 + 1; // 最低的 0 变成 1
        return num1;
    }
}
