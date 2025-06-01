package com.example.stack;

import java.util.ArrayDeque;

/**
 * <p>L2289:使数组按非递减顺序排列</p>
 * @author zhenwu
 * @date 2025/6/1 21:44
 */
public class L2289_TotalSteps {
    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int totalSteps(int[] nums) {
        int ans = 0;
        ArrayDeque<int[]> st = new ArrayDeque<>();
        for (var num : nums) {
            var maxT = 0;
            while (!st.isEmpty() && st.peek()[0] <= num)
                maxT = Math.max(maxT, st.pop()[1]);
            maxT = st.isEmpty() ? 0 : maxT + 1;
            ans = Math.max(ans, maxT);
            st.push(new int[]{num, maxT});
        }
        return ans;
    }
}
