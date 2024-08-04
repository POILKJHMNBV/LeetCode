package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L394:字符串解码</p>
 * @author zhenwu
 * @date 2024/8/4 14:55
 */
public class L394_DecodeString {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodeString(s));
    }

    private static String decodeString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (!deque.isEmpty() && deque.peek() != '[') {
                    sb.insert(0, deque.pop());
                }
                deque.pop();
                int num = 0;
                int t = 0;
                while (!deque.isEmpty() && Character.isDigit(deque.peek())) {
                    int a = deque.pop() - '0';
                    num = ((int) (Math.pow(10, t) * a) + num);
                    t++;
                }
                for (int i = 0; i < num; i++) {
                    for (char c : sb.toString().toCharArray()) {
                        deque.push(c);
                    }
                }
            } else {
                deque.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.removeLast());
        }
        return res.toString();
    }
}
