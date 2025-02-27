package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L1577:数的平方等于两数乘积的方法数</p>
 * @author zhenwu
 * @date 2025/2/27 22:47
 */
public class L1577_NumTriplets {
    public static void main(String[] args) {
        int[] nums1 = {100000, 100000, 100000};
        int[] nums2 = {100000, 100000, 100000};
        System.out.println(numTriplets(nums1, nums2));
    }

    /**
     * 双指针
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(1)
     */
    private static int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int cnt = 0;
        if (nums2.length > 1) {
            cnt += count(nums1, nums2);
        }
        if (nums1.length > 1) {
            cnt += count(nums2, nums1);
        }
        return cnt;
    }

    private static int count(int[] arrA, int[] arrB) {
        int cnt = 0, n = arrB.length;
        long maxProduct = (long) arrB[n - 1] * arrB[n - 2];
        for (int num : arrA) {
            long m = (long) num * num;
            if (m > maxProduct) {
                break;
            }
            int l = 0, r = n -1;
            while (l < r) {
                long a = arrB[l], b = arrB[r];
                if (m > a * b) {
                    l++;
                } else if (m < a * b) {
                    r--;
                } else {
                    int i = l, j = r;
                    while (i <= r && arrB[i] == a) {
                        i++;
                    }
                    while (j >= l && arrB[j] == b) {
                        j--;
                    }
                    if (i > r && j < l) {
                        int x = i - j - 1;
                        cnt += x * (x - 1) / 2;
                    } else {
                        cnt += (i - l) * (r - j);
                    }
                    l = i;
                    r = j;
                }
            }
        }
        return cnt;
    }
}
