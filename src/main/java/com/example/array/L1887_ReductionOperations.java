package com.example.array;

import java.util.Arrays;

/**
 * <p>L1887:使数组元素相等的减少操作次数</p>
 * @author zhenwu
 * @date 2025/3/22 10:14
 */
public class L1887_ReductionOperations {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     */
    private static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, k = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            ans += (j - i) * k++;
            i = j - 1;
        }
        return ans;
    }
}
