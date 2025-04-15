package com.example.binaryserach;

/**
 * <p>L1011:在 D 天内送达包裹的能力</p>
 * @author zhenwu
 * @date 2025/4/15 22:29
 */
public class L1011_ShipWithinDays {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    }

    /**
     * 时间：O(n log m), 其中 n 为 weights 的长度，m 为二分上下界之差。在本题数据范围下，m 不会超过 500 * 5 * 10^4
     * 空间：O(1)
     */
    private static int shipWithinDays(int[] weights, int days) {
        int r = 0;
        for (int weight : weights) {
            r += weight;
        }
        int l = weights[0];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canFinish(weights, m, days)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static boolean canFinish(int[] weights, int minWeight, int days) {
        int costDay = 0;
        for (int i = 0, n = weights.length; i < n; ) {
            if (weights[i] > minWeight) {
                return false;
            }
            int j = i, sum = 0;
            while (j < n && sum + weights[j] <= minWeight) {
                sum += weights[j++];
            }
            costDay++;
            i = j;
        }
        return days >= costDay;
    }
}
