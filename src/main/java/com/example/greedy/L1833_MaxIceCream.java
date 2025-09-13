package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L1833:雪糕的最大数量</p>
 * @author zhenwu
 * @date 2025/9/13 20:59
 */
public class L1833_MaxIceCream {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    private static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) {
                break;
            }
            count++;
        }
        return count;
    }
}
