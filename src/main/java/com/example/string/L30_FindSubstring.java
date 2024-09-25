package com.example.string;

import java.util.*;

/**
 * <p>L30:串联所有单词的子串</p>
 * @author zhenwu
 * @date 2024/9/25 20:35
 */
public class L30_FindSubstring {
    public static void main(String[] args) {
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = {"c", "b", "a", "c", "a", "a", "a", "b", "c"};
        System.out.println(findSubstring(s, words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length(), totalLen = words.length * words[0].length();
        if (totalLen > sLen) {
            return res;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= sLen - totalLen; i++) {
            for (int j = i; j < i + totalLen; j += len) {
                String key = s.substring(j, j + len);
                if (!wordsMap.containsKey(key)) {
                    break;
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            if (map.size() != wordsMap.size()) {
                map.clear();
                continue;
            }
            if (map.equals(wordsMap)) {
                res.add(i);
            }
            map.clear();
        }
        return res;
    }
}
