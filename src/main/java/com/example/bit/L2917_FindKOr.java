package com.example.bit;

/**
 * <p>L2917:找出数组中的 K-or 值</p>
 * @author zhenwu
 * @date 2025/6/21 15:39
 */
public class L2917_FindKOr {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n logU)，其中 U 是数组中的最大值，n 是数组的长度。
     * 空间复杂度: O(1)
     */
    private static int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
