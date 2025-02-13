package com.example.slidewindow;

/**
 * <p>L2106:摘水果</p>
 * @author zhenwu
 * @date 2025/2/13 21:56
 */
public class L2106_MaxTotalFruits {
    public static void main(String[] args) {
        int[][] fruits = {{0, 10000}};
        int startPos = 200000;
        int k = 0;
        System.out.println(maxTotalFruits(fruits, startPos, k));
        System.out.println(lowerBound(fruits, startPos - k));
    }

    /**
     * 滑动窗口 + 二分查找
     * 先左后右: (startPos - fruits[l][0]) + (fruits[r][0] - fruits[l][0]) <= k
     * 先右后左: (fruits[r][0] - startPos) + (fruits[r][0] - fruits[l][0]) <= k
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        if (startPos + k < fruits[0][0] || startPos - k > fruits[fruits.length - 1][0]) {
            return 0;
        }
        int l = lowerBound(fruits, startPos - k);
        int maxFruitCnt = 0;
        for (int r = l, n = fruits.length, fruitCnt = 0; r < n && fruits[r][0] <= startPos + k; r++) {
            fruitCnt += fruits[r][1];
            while (2 * fruits[r][0] - startPos - fruits[l][0] > k
                && startPos + fruits[r][0] - 2 * fruits[l][0] > k) {
                fruitCnt -= fruits[l++][1];
            }
            maxFruitCnt = Math.max(maxFruitCnt, fruitCnt);
        }
        return maxFruitCnt;
    }

    private static int lowerBound(int[][] fruits, int target) {
        int l = 0, r = fruits.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target > fruits[m][0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
