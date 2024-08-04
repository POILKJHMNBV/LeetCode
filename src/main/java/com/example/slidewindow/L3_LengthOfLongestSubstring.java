package com.example.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * L3:无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class L3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstringPlus(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        // key-字符   value-索引
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        char[] charArray = s.toCharArray();
        int left = 0, right = 0;
        while (right < length) {
            char ch = charArray[right];
            if (map.containsKey(ch)) {
                maxLength = Math.max(maxLength, right - left);
                int index = map.get(ch);
                if (index >= left) {
                    left = index + 1;
                }
            }
            map.put(ch, right);
            right++;
        }
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }

    private static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        // key-字符   value-索引
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        char[] chars = s.toCharArray();
        int left, right;
        for (left = 0, right = 0; right < length; right++) {
            char ch = chars[right];
            if (map.containsKey(ch)) {
                // map中包含此字符，更新左边界
                left = Math.max(map.get(ch) + 1, left);
            }
            // 更新字符的索引
            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}