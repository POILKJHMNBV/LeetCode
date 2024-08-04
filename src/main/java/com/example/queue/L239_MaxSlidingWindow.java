package com.example.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L239:滑动窗口最大值</p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class L239_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * 单调队列
     */
    private static int[] maxSlidingWindow(int[] nums, int k) {
        // 利用双端队列存储数组元素的下标
        Deque<Integer> deque = new LinkedList<>();

        int len = nums.length;
        // 结果集
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            // 窗口开始滑动，移除队首元素
            if (!deque.isEmpty() && i - deque.peekFirst() == k) {
                deque.removeFirst();
            }

            // 依次与队尾元素进行比较，移除队尾元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
