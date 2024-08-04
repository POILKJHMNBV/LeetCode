package com.example.slidewindow;

import java.util.*;

/**
 * <p>L438.找到字符串中所有字母异位词</p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class L438_FindAnagrams {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagramsPro(s, p));
    }

    private static List<Integer> findAnagramsPro(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return res;
        }

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int[] sCounter = new int[26];
        int[] pCounter = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCounter[sCharArray[i] - 'a']++;
            pCounter[pCharArray[i] - 'a']++;
        }

        if (Arrays.equals(sCounter, pCounter)) {
            res.add(0);
        }

        // 开始滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            // 将首位字符移除窗口
            sCounter[sCharArray[i] - 'a']--;
            // 将窗口右端第一个字符移入窗口
            sCounter[sCharArray[i + pLen] - 'a']++;

            if (Arrays.equals(sCounter, pCounter)) {
                res.add(i + 1);
            }
        }

        return res;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return res;
        }
        int left = 0, right = pLen;
        Map<Character, Integer> pCounter = characterCounter(p);
        while (right <= sLen) {
            String substring = s.substring(left, right);
            if (equals(pCounter, characterCounter(substring))) {
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }

    private static boolean equals(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        Set<Character> set = m1.keySet();
        for (Character key : set) {
            if (!m2.containsKey(key)) {
                return false;
            }
            if (!m1.get(key).equals(m2.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> characterCounter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }
        return map;
    }
}
