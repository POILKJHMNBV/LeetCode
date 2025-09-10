package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L3074:重新分装苹果</p>
 * @author zhenwu
 * @date 2025/9/10 21:32
 */
public class L3074_MinimumBoxes {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * log n + m)
     * 空间复杂度：O(1)
     */
    private static int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int j : apple) {
            sum += j;
        }
        Arrays.sort(capacity);
        int i = capacity.length - 1;
        while (i >= 0 && sum > 0) {
            sum -= capacity[i--];
        }
        return capacity.length - i - 1;
    }
}
