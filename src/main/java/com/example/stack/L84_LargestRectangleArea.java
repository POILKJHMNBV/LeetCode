package com.example.stack;

import java.util.ArrayDeque;

/**
 * <p>柱状图中最大的矩形</p>
 * <p>给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积</p>
 */
public class L84_LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {1, 2, 3, 4, 5};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * 单调栈
     */
    private static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int maxArea = 0;

        // 利用单调栈保存数组的索引
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                // 找到第一个严格小于栈顶元素高度的值，弹出栈顶元素，计算以栈顶元素为高度的柱形的面积
                int topIndex = stack.pop();

                // 向左搜寻第一个严格小于栈顶元素高度的值
                while (!stack.isEmpty() && heights[stack.peek()] == heights[topIndex]) {
                    stack.pop();
                }

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * heights[topIndex]);
            }
            stack.push(i);
        }

        // 计算栈中剩下元素为高度的柱形的面积
        while (!stack.isEmpty()) {

            int topIndex = stack.pop();

            // 向左搜寻第一个严格小于栈顶元素高度的值
            while (!stack.isEmpty() && heights[stack.peek()] == heights[topIndex]) {
                stack.pop();
            }

            int width = stack.isEmpty() ? len : len - stack.peek() - 1;
            maxArea = Math.max(maxArea, width * heights[topIndex]);
        }
        return maxArea;
    }
}
