package com.example.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>L907:子数组的最小值之和</p>
 * @author zhenwu
 * @date 2024/12/11 22:18
 */
public class L907_SumSubarrayMins {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // leftBoundIndex[i]表示i位置左边第一个小于arr[i]的值的索引
        int[] leftBoundIndex = new int[n];
        Arrays.fill(leftBoundIndex, -1);

        // rightBoundIndex[i]表示i位置右边第一个小于等于arr[i]的值的索引
        int[] rightBoundIndex = new int[n];
        Arrays.fill(rightBoundIndex, n);

        // 利用单调栈快速求取 leftBoundIndex 和 rightBoundIndex
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                rightBoundIndex[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                leftBoundIndex[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) arr[i] * (i - leftBoundIndex[i]) * (rightBoundIndex[i] - i);
        }
        return (int) (ans % 1000000007);
    }
}
