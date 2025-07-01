package com.example.bit;

/**
 * <p>L1829:每个查询的最大异或值</p>
 * @author zhenwu
 * @date 2025/7/1 21:58
 */
public class L1829_GetMaximumXor {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxNum = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] answer = new int[n];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            answer[i] = xor ^ maxNum;
            xor ^= nums[j];
        }
        return answer;
    }
}
