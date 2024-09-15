package com.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>L2542:最大子序列的分数</p>
 * @author zhenwu
 * @date 2024/9/14 21:58
 */
public class L2542_MaxScore {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 2}, nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));
    }


    /**
     * 小根堆
     * 初始化时间：O(n * log n)
     * 空间：O(n)
     */
    private static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // 对下标排序，不影响原数组的顺序
        Arrays.sort(ids, (i, j) -> nums2[j] - nums2[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums1[ids[i]];
            pq.offer(nums1[ids[i]]);
        }

        long ans = sum * nums2[ids[k - 1]];
        for (int i = k; i < n; i++) {
            int x = nums1[ids[i]];
            if (x > pq.peek()) {
                sum += x - pq.poll();
                pq.offer(x);
                ans = Math.max(ans, sum * nums2[ids[i]]);
            }
        }
        return ans;
    }
}
