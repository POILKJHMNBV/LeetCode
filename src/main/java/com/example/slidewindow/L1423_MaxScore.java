package com.example.slidewindow;

/**
 * <p>L1423:可获得的最大点数</p>
 * @author zhenwu
 * @date 2025/2/4 10:32
 */
public class L1423_MaxScore {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
        System.out.println(maxScorePro(cardPoints, k));
    }

    /**
     * 简单模拟
     * 时间复杂度：O(k)
     * 空间复杂度：O(1)
     */
    private static int maxScorePro(int[] cardPoints, int k) {
        int sum = 0, n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int l = k - 1, r = n - 1, maxSum = sum;
        while (l >= 0) {
            sum += cardPoints[r--] - cardPoints[l--];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    /**
     * 滑动窗口
     * 思路：逆向思维，即求 n - k 个数的最小值，即求窗口大小为 n - k 的滑动窗口的最小值。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, m = n - k;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += cardPoints[i];
        }
        int l = 0, r = m, minSum = sum, totalSum = sum;
        while (r < n) {
            totalSum += cardPoints[r];
            sum += cardPoints[r++] - cardPoints[l++];
            minSum = Math.min(minSum, sum);
        }
        return totalSum - minSum;
    }
}
