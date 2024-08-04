package com.example.stack;

import java.util.ArrayDeque;

/**
 * L42:接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */
public class L42_Trap {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }


    private static int trap(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(0);
        int sum = 0;
        for (int i = 1; i < length; i++) {
            while (!arrayDeque.isEmpty() && height[i] > height[arrayDeque.peek()]) {
                int top = arrayDeque.pop();
                if (arrayDeque.isEmpty()) {
                    break;
                }
                int w = i - arrayDeque.peek() - 1;
                int h = Math.min(height[arrayDeque.peek()], height[i]) - height[top];
                sum += (w * h);
            }
            arrayDeque.push(i);
        }
        return sum;
    }
}
