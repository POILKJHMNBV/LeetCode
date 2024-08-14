package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L242:有效的字母异位词</p>
 * <p>
 *     给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *     注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * </p>
 * @author zhenwu
 * @date 2024/8/14 21:23
 */
public class L242_IsAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> cntS = new HashMap<>();
        Map<Character, Integer> cntT = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntS.put(ch, cntS.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            cntT.put(ch, cntT.getOrDefault(ch, 0) + 1);
        }
        return cntS.equals(cntT);
    }
}
