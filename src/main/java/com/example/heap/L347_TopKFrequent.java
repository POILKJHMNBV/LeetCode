package com.example.heap;

import java.util.*;

/**
 * <p>L347:前 K 个高频元素</p>
 *
 * @author zhenwu
 * @date 2024/8/5 20:27
 */
public class L347_TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Counter> map = new HashMap<>();
        for (int num : nums) {
            map.computeIfAbsent(num, Counter::new).count++;
        }
        PriorityQueue<Counter> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.count));
        for (Counter value : map.values()) {
            minHeap.offer(value);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll().num;
        }
        return res;
    }

    private static class Counter {
        final int num;
        int count;

        public Counter(int num) {
            this.num = num;
        }
    }
}
