package com.example.slidewindow;

/**
 * <p>L343:大小为 K 且平均值大于等于阈值的子数组数目</p>
 * <p>
 *     给定一个整数数组 arr 和两个整数 k 和 threshold 。
 *     请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * </p>
 * @author zhenwu
 * @date 2025/2/2 15:59
 */
public class L1343_NumOfSubarrays {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }

    /**
     * 滑动窗口算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        if (len < k) {
            return 0;
        }
        int count = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if ((sum / k) >= threshold) {
            count++;
        }
        int l = 0, r = k;
        while (r < len) {
            sum += arr[r];
            sum -= arr[l];
            if ((sum / k) >= threshold) {
                count++;
            }
            r++;
            l++;
        }
        return count;
    }
}
