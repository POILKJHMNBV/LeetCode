package com.example.stack;

import java.util.ArrayDeque;
import java.util.List;

/**
 * <p>L2866:美丽塔 II</p>
 * @author zhenwu
 * @date 2025/5/21 21:42
 */
public class L2866_MaximumSumOfHeights {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] heights = maxHeights.stream().mapToInt(i -> i).toArray();
        int n = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 记录i位置左侧到i位置递增段的最大值
        long[] maxPre = new long[n];
        long sum = 0;
        // 哨兵
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (stack.size() > 1 && height <= heights[stack.peek()]) {
                int j = stack.pop();
                sum -= (long) heights[j] * (j - stack.peek());
            }
            sum += (long) heights[i] * (i - stack.peek());
            maxPre[i] = sum;
            stack.push(i);
        }

        stack.clear();
        stack.push(n);
        long ans = sum, suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            int height = heights[i];
            while (stack.size() > 1 && height <= heights[stack.peek()]) {
                int j = stack.pop();
                suf -= (long) heights[j] * (stack.peek() - j);
            }
            suf += (long) heights[i] * (stack.peek() - i);
            ans = Math.max(ans, i - 1 < 0 ? 0 : maxPre[i - 1] + suf);
            stack.push(i);
        }
        return ans;
    }
}
