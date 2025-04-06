package com.example.binaryserach;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L2070:每一个查询的最大美丽值</p>
 * @author zhenwu
 * @date 2025/4/6 20:44
 */
public class L2070_MaximumBeauty {

    public static void main(String[] args) {
        int[][] items = {
                {1, 2},
                {3, 2},
                {2, 4},
                {5, 6},
                {3, 5}
        };
        int[] queries = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    /**
     * 时间：O((n + m) * log n)，其中 n 是 nums 的长度，q 是 queries 的长度。
     * 空间：O(m)
     */
    private static int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        for (int i = 1, n = items.length; i < n; i++) {
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0, m = queries.length; i < m; i++) {
            int idx = query(items, queries[i]);
            if (idx >= 0) {
                ans[i] = items[idx][1];
            }
        }
        return ans;
    }

    private static int query(int[][] items, int target) {
        int l = 0, r = items.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (items[m][0] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
