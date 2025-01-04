package com.example.bit;

/**
 * <p>L421:数组中两个数的最大异或值</p>
 * @author zhenwu
 * @date 2025/1/4 21:08
 */
public class L421_FindMaximumXOR {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法(超时)
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    private static int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            for (int num1 : nums) {
                max = Math.max(num ^ num1, max);
            }
        }
        return max;
    }
}
