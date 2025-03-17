package com.example.doublepointer;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * <p>L795:区间子数组个数</p>
 * @author zhenwu
 * @date 2025/3/17 21:52
 */
public class L795_NumSubarrayBoundedMax {
    public static void main(String[] args) {
        int[] nums = {2, 9, 2, 5, 6};
        int left = 2, right = 8;
        System.out.println(numSubarrayBoundedMax(nums, left, right));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int numSubarrayBoundedMaxPro(int[] nums, int left, int right) {
        int n = nums.length, ans = 0, l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                l = i;
            }
            if (nums[i] >= left) {
                r = i;
            }
            ans += r - l;
        }
        return ans;
    }


    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        Arrays.fill(leftMax, -1);
        Arrays.fill(rightMax, n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                rightMax[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                leftMax[stack.pop()] = i;
            }
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < left || nums[i] > right) {
                continue;
            }
            ans += (rightMax[i] - i) * (i - leftMax[i]);
        }
        return ans;
    }
}
