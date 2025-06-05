package com.example.stack;

import java.util.ArrayDeque;

/**
 * <p>L1124:表现良好的最长时间段</p>
 * @author zhenwu
 * @date 2025/6/5 22:19
 */
public class L1124_LongestWPI {
    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int longestWPI(int[] hours) {
        int n = hours.length, ans = 0;
        int[] prefixSum = new int[n + 1]; // 前缀和
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0); // prefixSum[0]
        for (int j = 1; j <= n; ++j) {
            prefixSum[j] = prefixSum[j - 1] + (hours[j - 1] > 8 ? 1 : -1);
            if (prefixSum[j] < prefixSum[st.peek()]) st.push(j); // 感兴趣的 j
        }
        for (int i = n; i > 0; --i)
            while (!st.isEmpty() && prefixSum[i] > prefixSum[st.peek()])
                ans = Math.max(ans, i - st.pop()); // [栈顶,i) 可能是最长子数组
        return ans;
    }
}
