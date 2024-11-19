package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L290:单词规律</p>
 * @author zhenwu
 * @date 2024/11/19 21:46
 */
public class L290_WordPattern {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (chars.length != words.length) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map1.containsKey(chars[i])) {
                if (!map1.get(chars[i]).equals(words[i])) {
                    return false;
                }
            }
            if (map2.containsKey(words[i])) {
                if (map2.get(words[i]) != chars[i]) {
                    return false;
                }
            }
            map1.put(chars[i], words[i]);
            map2.put(words[i], chars[i]);
        }
        return true;
    }
}
