package com.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L933:最近的请求次数</p>
 * @author zhenwu
 * @date 2024/9/5 20:56
 */
public class L933_RecentCounter {
    public static void main(String[] args) {

    }

    static class RecentCounter {

        private final Deque<Integer> deque;

        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!deque.isEmpty() && t - deque.peekFirst() > 3000) {
                deque.poll();
            }
            deque.offer(t);
            return deque.size();
        }
    }
}
