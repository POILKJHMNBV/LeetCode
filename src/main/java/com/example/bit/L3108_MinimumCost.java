package com.example.bit;

import java.util.Arrays;

/**
 * <p>L3108:带权图里旅途的最小代价</p>
 * @author zhenwu
 * @date 2025/7/17 21:58
 */
public class L3108_MinimumCost {
    public static void main(String[] args) {

    }

    /**
     * 并查集
     * 时间复杂度：O((n + m + q)logn)，其中 m 为 edges 的长度，q 为 query 的长度
     * 空间复杂度：O(n)
     */
    private static int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        int[] and = new int[n];
        Arrays.fill(and, -1);

        for (int[] e : edges) {
            int x = find(e[0], fa);
            int y = find(e[1], fa);
            and[y] &= e[2];
            if (x != y) {
                and[y] &= and[x];
                fa[x] = y;
            }
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];
            ans[i] = find(s, fa) != find(t, fa) ? -1 : and[find(s, fa)];
        }
        return ans;
    }

    private static int find(int x, int[] fa) {
        if (fa[x] != x) {
            fa[x] = find(fa[x], fa);
        }
        return fa[x];
    }
}
