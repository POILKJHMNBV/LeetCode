package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L1561:你可以获得的最大硬币数目</p>
 * @author zhenwu
 * @date 2025/9/25 21:37
 */
public class L1561_MaxCoins {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     */
    private static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        // [0, piles.length / 3 - 1]全是Bob取，每次取最小的，我们每次取次大的
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            res += piles[i];
        }
        return res;
    }
}
