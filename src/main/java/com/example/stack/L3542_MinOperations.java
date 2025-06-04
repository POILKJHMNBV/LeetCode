package com.example.stack;

/**
 * <p>L3542:将所有元素变为 0 的最少操作次数</p>
 * @author zhenwu
 * @date 2025/6/4 21:59
 */
public class L3542_MinOperations {
    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int minOperations(int[] nums) {
        int ans = 0;
        int top = -1; // 栈顶下标（把 nums 当作栈）
        for (int x : nums) {
            while (top >= 0 && x < nums[top]) {
                top--; // 出栈
                ans++;
            }
            // 如果 x 与栈顶相同，那么 x 与栈顶可以在同一次操作中都变成 0，x 无需入栈
            if (top < 0 || x != nums[top]) {
                nums[++top] = x; // 入栈
            }
        }
        return ans + top + (nums[0] > 0 ? 1 : 0);
    }
}
