package com.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * <p>L503:下一个更大元素 II</p>
 * @author zhenwu
 * @date 2025/5/17 9:32
 */
public class L503_NextGreaterElements {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, m = 2 * n; i < m; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]) {
                ans[stack.pop() % n] = nums[i % n];
            }
            stack.push(i);
        }
        return ans;
    }
}
