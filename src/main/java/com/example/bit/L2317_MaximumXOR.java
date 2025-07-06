package com.example.bit;

/**
 * <p>L2317:操作后的最大异或和</p>
 * @author zhenwu
 * @date 2025/7/6 20:31
 */
public class L2317_MaximumXOR {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int maximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) ans |= num;
        return ans;
    }
}
