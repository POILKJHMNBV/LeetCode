package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L901:股票价格跨度</p>
 *
 * @author zhenwu
 * @date 2024/9/18 21:32
 */
public class L901_StockSpanner {
    public static void main(String[] args) {

    }

    static class StockSpanner {

        private final Deque<int[]> deque;
        private int cur = 0;

        public StockSpanner() {
            deque = new ArrayDeque<>();
        }

        public int next(int price) {
            while (!deque.isEmpty() && deque.peek()[1] <= price) {
                deque.pop();
            }
            int prev = deque.isEmpty() ? -1 : deque.peek()[0];
            int ans = cur - prev;
            deque.push(new int[]{cur++, price});
            return ans;
        }
    }
}
