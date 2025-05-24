package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L1944:队列中可以看到的人数</p>
 * @author zhenwu
 * @date 2025/5/24 21:49
 */
public class L1944_CanSeePersonsCount {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < heights[i]) {
                st.pop();
                ans[i]++;
            }
            if (!st.isEmpty()) { // 还可以再看到一个人
                ans[i]++;
            }
            st.push(heights[i]);
        }
        return ans;
    }
}
