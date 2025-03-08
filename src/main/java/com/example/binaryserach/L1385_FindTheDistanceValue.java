package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L1385:两个数组间的距离值</p>
 * @author zhenwu
 * @date 2025/3/8 9:06
 */
public class L1385_FindTheDistanceValue {
    public static void main(String[] args) {

    }

    /**
     * 排序 + 二分查找
     * 时间复杂度：O(n log m + m log m)
     * 空间复杂度：O(1)
     */
    private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0, n = arr2.length;
        for (int x : arr1) {
            int p = search(arr2, x);
            boolean ok = true;
            if (p < n) {
                ok = Math.abs(x - arr2[p]) > d;
            }
            if (p - 1 >= 0) {
                ok &= Math.abs(x - arr2[p - 1]) > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    private static int search(int[] arr2, int target) {
        int l = 0, r = arr2.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target > arr2[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
