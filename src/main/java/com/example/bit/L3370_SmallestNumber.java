package com.example.bit;

/**
 * <p>L3370:仅含置位位的最小整数</p>
 * @author zhenwu
 * @date 2025/6/16 22:00
 */
public class L3370_SmallestNumber {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     */
    private static int smallestNumber(int n) {
        int m = 32 - Integer.numberOfLeadingZeros(n);
        return (1 << m) - 1;
    }
}
