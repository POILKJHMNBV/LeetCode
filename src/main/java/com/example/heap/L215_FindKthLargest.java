package com.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * <p>L215:数组中的第K个最大元素</p>
 * @author zhenwu
 * @date 2024/8/4 21:48
 */
public class L215_FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 7, 8, 2};
        System.out.println(Arrays.toString(partition(nums, 0, nums.length - 1)));
    }

    /**
     * 小根堆
     * 时间：O(n * log K)  空间：O(k)
     */
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

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static int findKthLargestPro(int[] nums, int k) {
        int len = nums.length;
        int targetIndex = len - k;
        int l = 0, r = len - 1;
        while (true) {
            int[] boundary = partition(nums, l, r);
            if (targetIndex >= boundary[0] && targetIndex <= boundary[1]) {
                return nums[targetIndex];
            } else if (targetIndex < boundary[0]) {
                r = boundary[0] - 1;
            } else {
                l = boundary[1] + 1;
            }
        }
    }

    private static int[] partition(int[] nums, int l, int r) {
        int left = l - 1, right = r + 1;
        Random random = new Random();
        int target = nums[l + random.nextInt(r - l + 1)];
        while (l < right) {
            if (nums[l] < target) {
                swap(nums, ++left, l++);
            } else if (nums[l] > target) {
                swap(nums, --right, l);
            } else {
                l++;
            }
        }
        return new int[]{left + 1, right - 1};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
