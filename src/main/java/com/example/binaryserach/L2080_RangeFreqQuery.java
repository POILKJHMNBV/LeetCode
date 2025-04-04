package com.example.binaryserach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L2080:区间内查询数字的频率</p>
 * @author zhenwu
 * @date 2025/4/4 22:38
 */
public class L2080_RangeFreqQuery {

    public static void main(String[] args) {

    }

    static class RangeFreqQuery {

        private final Map<Integer, List<Integer>> pos = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0, n = arr.length; i < n; i++) {
                pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> idxList = pos.get(value);
            if (idxList == null) {
                return 0;
            }
            // > right 等价于 >= right+1
            return lowerBound(idxList, right + 1) - lowerBound(idxList, left);
        }

        private int lowerBound(List<Integer> idxList, int target) {
            int left = -1;
            int right = idxList.size();
            while (left + 1 < right) { // 区间不为空
                // 循环不变量：
                // a[left] < target
                // a[right] >= target
                int mid = (left + right) >>> 1;
                if (idxList.get(mid) < target) {
                    left = mid; // 范围缩小到 (mid, right)
                } else {
                    right = mid; // 范围缩小到 (left, mid)
                }
            }
            return right; // right 是最小的满足 a[right] >= target 的下标
        }
    }
}
