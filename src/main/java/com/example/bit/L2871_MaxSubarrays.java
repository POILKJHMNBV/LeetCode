package com.example.bit;

/**
 * <p>L2871:将数组分割成最多数目的子数组</p>
 * @author zhenwu
 * @date 2025/7/14 22:05
 */
public class L2871_MaxSubarrays {
    public static void main(String[] args) {

    }

    /**
     * AND 的性质是，参与 AND 的数越多，结果越小
     * 子数组的 AND，不会低于整个 nums 数组的 AND
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxSubarrays(int[] nums) {
        int ans = 0, cur = -1;
        for (int num : nums) {
            cur &= num;
            if (cur == 0) {
                ans++;
                cur = -1;
            }
        }
        return Math.max(ans, 1);
    }
}
