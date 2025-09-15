package com.example.greedy;

import java.util.*;

/**
 * <p>L1481:不同整数的最少数目</p>
 * @author zhenwu
 * @date 2025/9/15 21:23
 */
public class L1481_FindLeastNumOfUniqueInts {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Pair> cntMap = new HashMap<>();
        for (int num : arr) {
            cntMap.computeIfAbsent(num, key -> new Pair(num, 0)).cnt++;
        }
        List<Pair> cntList = new ArrayList<>(cntMap.values());
        cntList.sort(Comparator.comparingInt(o -> o.cnt));
        int j = 0;
        for (int i = 0, n = cntList.size(); i < n && k >= cntList.get(i).cnt; i++) {
            k -= cntList.get(i).cnt;
            j++;
        }
        return cntList.size() - j;
    }

    private static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
