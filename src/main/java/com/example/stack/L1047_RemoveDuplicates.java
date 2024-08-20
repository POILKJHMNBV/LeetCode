package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L1047:删除字符串中的所有相邻重复项</p>
 * @author zhenwu
 * @date 2024/8/20 20:52
 */
public class L1047_RemoveDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    private static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chars) {
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.removeLast());
        }
        return res.toString();
    }
}
