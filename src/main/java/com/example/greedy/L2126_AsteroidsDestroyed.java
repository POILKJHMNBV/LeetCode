package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L2126:摧毁小行星</p>
 * @author zhenwu
 * @date 2025/9/22 21:37
 */
public class L2126_AsteroidsDestroyed {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     */
    private static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int i = 0, n = asteroids.length; i < n; i++) {
            if (mass < asteroids[i]) {
                return false;
            }
            mass += asteroids[i];
            if (mass >= asteroids[n - 1]) {
                break;
            }
        }
        return true;
    }
}
