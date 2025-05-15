package com.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L496:下一个更大元素 I</p>
 * @author zhenwu
 * @date 2025/5/15 22:07
 */
public class L496_NextGreaterElement {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n)
     */
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int idx = stack.pop();
                nums[idx] = nums2[i];
            }
            stack.push(i);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = nums[map.get(nums1[i])];
        }
        return ans;
    }
}
