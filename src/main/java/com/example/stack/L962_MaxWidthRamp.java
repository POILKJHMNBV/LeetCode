package com.example.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L962:最大宽度坡</p>
 * @author zhenwu
 * @date 2025/5/20 22:17
 */
public class L962_MaxWidthRamp {

    public static void main(String[] args) {
        int[] nums = {6, 10, 8, 2, 1, 5};
        System.out.println(maxWidthRamp(nums));
    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maxWidthRamp(int[] nums) {
        int res = 0, n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (dq.isEmpty() || nums[i] < nums[dq.getLast()]) {
                dq.offer(i);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (dq.isEmpty()) break;
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                res = Math.max(res, i - dq.removeLast());
            }
        }
        return res;
    }
}
