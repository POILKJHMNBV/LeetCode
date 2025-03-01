package com.example.doublepointer;

import java.util.*;

/**
 * <p>L1782:统计点对的数目</p>
 * @author zhenwu
 * @date 2025/3/1 21:25
 */
public class L1782_CountPairs {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,5},{1,5},{3,4},{2,5},{1,3},{5,1},{2,3},{2,5}};
        int[] queries = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(countPairs(n, edges, queries)));
    }

    private static int[] countPairsPro(int n, int[][] edges, int[] queries) {
        // deg[i] 表示与点 i 相连的边的数目
        int[] deg = new int[n + 1]; // 节点编号从 1 到 n
        Map<Integer, Integer> cntE = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (x > y) {
                // 交换 x 和 y，因为 1-2 和 2-1 算同一条边
                int tmp = x;
                x = y;
                y = tmp;
            }
            deg[x]++;
            deg[y]++;
            // 统计每条边的出现次数
            // 用一个 int 存储两个不超过 65535 的数
            cntE.merge(x << 16 | y, 1, Integer::sum); // cntE[x<<16|y]++
        }

        int[] ans = new int[queries.length];
        int[] sortedDeg = deg.clone();
        Arrays.sort(sortedDeg); // 排序，为了双指针
        for (int j = 0; j < queries.length; j++) {
            int q = queries[j];
            int left = 1, right = n; // 相向双指针
            while (left < right) {
                if (sortedDeg[left] + sortedDeg[right] <= q) {
                    left++;
                } else {
                    ans[j] += right - left;
                    right--;
                }
            }
            for (Map.Entry<Integer, Integer> e: cntE.entrySet()) {
                int k = e.getKey(), c = e.getValue();
                int s = deg[k >> 16] + deg[k & 0xffff]; // 取出 k 的高 16 位和低 16 位
                if (s > q && s - c <= q) {
                    ans[j]--;
                }
            }
        }
        return ans;
    }

    private static int[] countPairs(int n, int[][] edges, int[] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        TreeMap<Integer, Integer> cntEdgeMap = new TreeMap<>();
        for (int[] edge : edges) {
            cntEdgeMap.merge(edge[0], 1, Integer::sum);
        }
        int[] keys = cntEdgeMap.keySet().stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < len; i++) {
            ans[i] = doCount(keys, queries[i], cntEdgeMap);
        }
        return ans;
    }

    private static int doCount(int[] keys, int target, TreeMap<Integer, Integer> cntEdgeMap) {
        int n = keys.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = cntEdgeMap.getOrDefault(keys[i], 0);
            for (int j = i + 1; j < n; j++) {
                if (x + cntEdgeMap.getOrDefault(keys[j], 0) > target) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
