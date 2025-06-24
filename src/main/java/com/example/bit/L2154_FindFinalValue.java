package com.example.bit;

/**
 * <p>L2154:将找到的值乘以 2</p>
 * @author zhenwu
 * @date 2025/6/24 21:46
 */
public class L2154_FindFinalValue {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        System.out.println(findFinalValue(nums, original));
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int findFinalValue(int[] nums, int original) {
        int mask = 0;
        for (int num : nums) {
            if (num % original != 0) {
                continue;
            }
            int k = num / original;
            if ((k & (k - 1)) != 0) {
                continue;
            }
            mask |= k;
        }
        mask = ~mask;
        return original * (mask & -mask);
    }
}
