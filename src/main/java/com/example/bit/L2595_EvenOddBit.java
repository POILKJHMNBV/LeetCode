package com.example.bit;

/**
 * <p>L2595:奇偶位数</p>
 * @author zhenwu
 * @date 2025/6/23 22:03
 */
public class L2595_EvenOddBit {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     */
    private static int[] evenOddBit(int n) {
        final int MASK = 0x55555555;
        return new int[]{Integer.bitCount(n & MASK), Integer.bitCount(n & ~MASK)};
    }
}
