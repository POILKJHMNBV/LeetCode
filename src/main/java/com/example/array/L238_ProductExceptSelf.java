package com.example.array;

import java.util.Arrays;

/**
 * <p>L238:除自身以外数组的乘积</p>
 * <p>给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。</p>
 */
public class L238_ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int k = 1;
        for (int i = 0; i < length; i++) {
            ans[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] *= k;
            k *= nums[i];
        }
        return ans;
    }
}
