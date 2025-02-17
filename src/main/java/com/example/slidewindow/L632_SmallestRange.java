package com.example.slidewindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>L632:最小区间</p>
 * @author zhenwu
 * @date 2025/2/17 20:37
 */
public class L632_SmallestRange {
    public static void main(String[] args) {

    }

    /**
     * 排序 + 滑动窗口
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int[] smallestRange(List<List<Integer>> nums) {
        int n = 0;
        for (List<Integer> list : nums) {
            n += list.size();
        }
        // 在pairs上寻找满足条件的最小区间
        int[][] pairs = new int[n][2];
        int i = 0;
        for (int idx = 0; idx < nums.size(); idx++) {
            for (int num : nums.get(idx)) {
                pairs[i][0] = num;
                pairs[i++][1] = idx;
            }
        }

        Arrays.sort(pairs, Comparator.comparing(pair -> pair[0]));
        int matches = nums.size(), left = pairs[0][0], right = pairs[n - 1][0];
        int[] cnt = new int[matches];
        for (int l = 0, r = 0, match = 0; r < n; r++) {
            int num = pairs[r][0], idx = pairs[r][1];
            if (cnt[idx] == 0) {
                match++;
            }
            cnt[idx]++;
            while (match == matches) {
                if (num - pairs[l][0] < right - left) {
                    left = pairs[l][0];
                    right = num;
                }
                idx = pairs[l++][1];
                cnt[idx]--;
                if (cnt[idx] == 0) {
                    match--;
                }
            }
        }
        return new int[]{left, right};
    }
}
