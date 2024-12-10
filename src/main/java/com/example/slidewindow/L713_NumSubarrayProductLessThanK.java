package com.example.slidewindow;

/**
 * <p>L713:乘积小于 K 的子数组</p>
 * @author zhenwu
 * @date 2024/12/10 21:40
 */
public class L713_NumSubarrayProductLessThanK {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for (int i = 0, j = 0, product = 1; i < nums.length; i++) {
            product *= nums[i];
            while (j <= i && product >= k) {
                // 收缩左边界
                product /= nums[j];
                j++;
            }
            // [j, i] 区间内乘积都小于 k
            res += i - j + 1;
        }
        return res;
    }
}
