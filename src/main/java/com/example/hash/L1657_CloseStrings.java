package com.example.hash;

import java.util.*;

/**
 * <p>L1657:确定两个字符串是否接近</p>
 * @author zhenwu
 * @date 2024/9/3 20:09
 */
public class L1657_CloseStrings {
    public static void main(String[] args) {
        String word1 = "abbzzca", word2 = "babzzcz";
        System.out.println(closeStrings(word1, word2));
    }

    private static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = count(word1);
        Map<Character, Integer> map2 = count(word2);

        List<Integer> values1 = new ArrayList<>(map1.values());
        List<Integer> values2 = new ArrayList<>(map2.values());
        Set<Character> set1 = new HashSet<>(map1.keySet());
        Set<Character> set2 = new HashSet<>(map2.keySet());
        Collections.sort(values1);
        Collections.sort(values2);
        return values1.equals(values2) && set1.equals(set2);
    }

    private static Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
