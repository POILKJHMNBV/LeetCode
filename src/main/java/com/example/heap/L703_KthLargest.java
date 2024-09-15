package com.example.heap;

import java.util.PriorityQueue;

/**
 * <p>L703:数据流中的第 K 大元素</p>
 * @author zhenwu
 * @date 2024/9/15 16:29
 */
public class L703_KthLargest {
    public static void main(String[] args) {
        int k = 3;
        int[] nums =  {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, nums);
    }

    /**
     * 小根堆
     * 初始化时间：O(n * log K)   插入时间：O(log k)
     * 空间：O(k)
     */
    static class KthLargest {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }
}
