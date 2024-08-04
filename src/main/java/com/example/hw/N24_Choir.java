package com.example.hw;

import java.util.Arrays;

/**
 * @author zhenwu
 */
public class N24_Choir {
    public static void main(String[] args) {
        int[] heights = {186, 186, 150, 200, 160, 130, 197, 200};
        System.out.println(minLeaveOutForChoir(heights));
    }

    private static int minLeaveOutForChoir(int[] heights) {
        int n = heights.length;
        int[] increasing = new int[n];// 从左到右的最长上升子序列长度
        int[] decreasing = new int[n];// 从右到左的最长上升子序列长度
        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);

        // 计算从左到右的最长上升子序列长度
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (heights[j] < heights[i]) {
                    increasing[i] = Math.max(increasing[i], increasing[j] + 1);
                }
            }
        }

        // 计算从右到左的最长上升子序列长度
        for (int i = n - 2; i >= 0 ;i--) {
            for (int j = n - 1; j > i; j--) {
                if (heights[j] < heights[i]) {
                    decreasing[i] = Math.max(decreasing[i], decreasing[j] + 1);
                }
            }
        }

        int maxFormation = 0;// 最大的合唱队形长度
        for (int i = 0;i < n;i++) {
            int formation = increasing[i] + decreasing[i] - 1;
            maxFormation = Math.max(maxFormation, formation);
        }

        return n - maxFormation;// 最少需要移除的同学数量
    }
}
