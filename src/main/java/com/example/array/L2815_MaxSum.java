package com.example.array;

/**
 * <p>L2815:数组中的最大数对和</p>
 * @author zhenwu
 * @date 2025/4/29 22:10
 */
public class L2815_MaxSum {
    public static void main(String[] args) {
        int[] nums = {51, 71, 17, 24, 42};
        System.out.println(maxSum(nums));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxSum(int[] nums) {
        int[] maxArray = new int[10];
        int ans = -1;
        for (int num : nums) {
            int idx = maxNum(num);
            if (maxArray[idx] != 0) {
                ans = Math.max(ans, maxArray[idx] + num);
                maxArray[idx] = Math.max(maxArray[idx], num);
            } else {
                maxArray[idx] = num;
            }
        }
        return ans;
    }

    private static int maxNum(int num) {
        int ans = 0;
        while (num != 0) {
            ans = Math.max(ans, num % 10);
            num /= 10;
        }
        return ans;
    }
}
