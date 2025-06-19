package com.example.bit;

/**
 * <p>L2220:转换数字的最少位翻转次数</p>
 * @author zhenwu
 * @date 2025/6/19 22:05
 */
public class L2220_MinBitFlips {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     */
    private static int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
