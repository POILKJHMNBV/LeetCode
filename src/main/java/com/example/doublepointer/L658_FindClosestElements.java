package com.example.doublepointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>L658:找到 K 个最接近的元素</p>
 * @author zhenwu
 * @date 2025/2/25 21:32
 */
public class L658_FindClosestElements {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int k = 3;
        int x = 5;
        List<Integer> list = findClosestElements(arr, k, x);
        System.out.println(list);
    }

    /**
     * 二分查找 + 双指针
     * 时间复杂度：O(log n + k * log k)
     * 空间复杂度：O(1)
     */
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int i = l - 1, j = l;
        List<Integer> ans = new ArrayList<>();
        while (k > 0 && (i >= 0 || j < n)) {
            k--;
            if (i < 0) {
                ans.add(arr[j++]);
                continue;
            }
            if (j >= n) {
                ans.add(arr[i--]);
                continue;
            }
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                ans.add(arr[i--]);
            } else {
                ans.add(arr[j++]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
