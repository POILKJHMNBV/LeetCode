package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L1130:叶值的最小代价生成树</p>
 * @author zhenwu
 * @date 2025/5/26 22:21
 */
public class L1130_MctFromLeafValues {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Deque<Integer> stk = new ArrayDeque<Integer>();
        for (int x : arr) {
            while (!stk.isEmpty() && stk.peek() <= x) {
                int y = stk.pop();
                if (stk.isEmpty() || stk.peek() > x) {
                    res += y * x;
                } else {
                    res += stk.peek() * y;
                }
            }
            stk.push(x);
        }
        while (stk.size() >= 2) {
            int x = stk.pop();
            res += stk.peek() * x;
        }
        return res;
    }
}
