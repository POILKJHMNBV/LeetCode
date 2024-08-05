package com.example.heap;

import java.util.PriorityQueue;

/**
 * <p>L215:数组中的第K个最大元素</p>
 * @author zhenwu
 * @date 2024/8/4 21:48
 */
public class L215_FindKthLargest {
    public static void main(String[] args) {

    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                // 移除前面比第k个数小的数
                heap.poll();
            }
        }
        return heap.peek();
    }
}
