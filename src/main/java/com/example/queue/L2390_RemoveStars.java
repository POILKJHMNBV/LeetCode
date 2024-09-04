package com.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * L2390:从字符串中移除星号
 * @author zhenwu
 * @date 2024/9/4 20:40
 */
public class L2390_RemoveStars {
    public static void main(String[] args) {

    }

    private static String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                deque.offerLast(ch);
                continue;
            }
            if (!deque.isEmpty()) {
                deque.removeLast();
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append(deque.pollFirst());
        }
        return ans.toString();
    }
}
