package com.example.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L3605:数组的最小稳定性因子</p>
 * @author zhenwu
 * @date 2025/8/14 23:01
 */
public class L3605_MinStable {
    public static void main(String[] args) {

    }

    private static int minStable(int[] nums, int maxC) {
        int left = -1;
        int right = nums.length / (maxC + 1);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, maxC, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private static boolean check(int[] nums, int maxC, int upper) {
        List<int[]> intervals = new ArrayList<>(); // 每个元素是 (子数组 GCD，最小左端点)
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // 计算以 i 为右端点的子数组 GCD
            for (int[] interval : intervals) {
                interval[0] = gcd(interval[0], x);
            }
            // nums[i] 单独一个数作为子数组
            intervals.add(new int[]{x, i});

            // 去重（合并 GCD 相同的区间）
            int idx = 1;
            for (int j = 1; j < intervals.size(); j++) {
                if (intervals.get(j)[0] != intervals.get(j - 1)[0]) {
                    intervals.set(idx, intervals.get(j));
                    idx++;
                }
            }
            intervals.subList(idx, intervals.size()).clear();

            // intervals 的性质：越靠左，GCD 越小

            // 我们只关心 GCD >= 2 的子数组
            if (intervals.get(0)[0] == 1) {
                intervals.remove(0);
            }

            // intervals[0] 的 GCD >= 2 且最长，取其区间左端点作为子数组的最小左端点
            if (!intervals.isEmpty() && i - intervals.get(0)[1] + 1 > upper) {
                if (maxC == 0) {
                    return false;
                }
                maxC--;
                intervals.clear(); // 修改后 GCD 均为 1，直接清空
            }
        }
        return true;
    }

    private static int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
