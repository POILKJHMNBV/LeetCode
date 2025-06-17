package com.example.bit;

/**
 * <p>L3226:仅含置位位的最小整数</p>
 * @author zhenwu
 * @date 2025/6/17 22:12
 */
public class L3226_MinChanges {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     */
    private static int minChanges(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }
}
