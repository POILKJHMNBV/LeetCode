package com.example.doublepointer;

/**
 * <p>L2105:给植物浇水 II</p>
 * @author zhenwu
 * @date 2025/2/25 21:25
 */
public class L2105_MinimumRefill {
    public static void main(String[] args) {
        int[] plants = {2, 2, 3, 3};
        int capacityA = 5;
        int capacityB = 5;
        System.out.println(minimumRefill(plants,capacityA,capacityB));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1, m = capacityA, n = capacityB, ans = 0;
        while (l < r) {
            int lv = plants[l++], rv = plants[r--];
            if (capacityA < lv) {
                ans++;
                capacityA = m - lv;
            } else {
                capacityA -= lv;
            }

            if (capacityB < rv) {
                ans++;
                capacityB = n - rv;
            } else {
                capacityB -= rv;
            }
        }
        if (l == r && plants[l] > Math.max(capacityA, capacityB)) {
            ans++;
        }
        return ans;
    }
}
