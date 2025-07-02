package com.example.bit;

/**
 * <p>L2997:使数组异或和等于 K 的最少操作次数</p>
 * @author zhenwu
 * @date 2025/7/2 21:45
 */
public class L2997_MinOperations {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int minOperations(int[] nums, int k) {
        for (int x : nums) {
            k ^= x;
        }
        return Integer.bitCount(k);
    }
}
