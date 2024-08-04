package com.example.stack;

import java.util.ArrayDeque;

/**
 * L316:去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 */
public class L316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbcd";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        int length = s.length();
        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (arrayDeque.contains(ch)) {
                continue;
            }
            while (!arrayDeque.isEmpty() && ch < arrayDeque.peek() && (lastIndex[arrayDeque.peek() - 'a']) > i) {
                arrayDeque.pop();
            }
            arrayDeque.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : arrayDeque) {
            sb.insert(0, character);
        }
        return sb.toString();
    }
}
