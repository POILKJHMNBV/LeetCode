package com.example.doublepointer;

/**
 * L42:接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */
public class L42_Trap {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }
        int sum = 0;
        int left = 1, right = length - 2;
        int leftValue = height[0];
        int rightValue = height[length - 1];
        while (left <= right) {
            int minimum = Math.min(leftValue, rightValue);
            if (minimum == leftValue) {
                if (minimum > height[left]) {
                    sum += minimum - height[left];
                }
                leftValue = Math.max(leftValue, height[left]);
                left++;
            } else {
                if (minimum > height[right]) {
                    sum += minimum - height[right];
                }
                rightValue = Math.max(rightValue, height[right]);
                right--;
            }
        }
        return sum;
    }
}
