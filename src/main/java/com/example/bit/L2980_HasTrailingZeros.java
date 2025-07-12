package com.example.bit;

/**
 * <p>L2980:检查按位或是否存在尾随零</p>
 * @author zhenwu
 * @date 2025/7/12 20:40
 */
public class L2980_HasTrailingZeros {
    public static void main(String[] args) {

    }

    /**
     * 判断是否有至少两个偶数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean hasTrailingZeros(int[] nums) {
        int even = nums.length;
        for (int num : nums) {
            even -= num % 2;
        }
        return even >= 2;
    }
}
