package com.example.bit;

/**
 * <p>L2527:查询数组异或美丽值</p>
 * @author zhenwu
 * @date 2025/7/5 21:44
 */
public class L2527_XorBeauty {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int xorBeauty(int[] nums) {
        int ans = 0;
        for (int x : nums) ans ^= x;
        return ans;
    }
}
