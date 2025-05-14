package com.example.stack;

import java.util.ArrayDeque;

/**
 * <p>L1475:商品折扣后的最终价格</p>
 * @author zhenwu
 * @date 2025/5/14 22:17
 */
public class L1475_FinalPrices {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.poll();
                ans[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.poll();
            ans[idx] = prices[idx];
        }
        return ans;
    }
}
