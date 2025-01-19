package com.example.hash;

import java.util.*;

/**
 * @author zhenwu
 * @date 2025/1/19 20:19
 */
public class L451_FrequencySort {
    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(frequencySort(s));
    }

    /**
     * 时间复杂度：O(n + nlogn)
     * 空间复杂度：O(n)
     */
    private static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : chars) {
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }
        Map<Integer, List<Character>> frequentMap = new TreeMap<>((o1, o2) -> o2 - o1);
        cntMap.forEach((k, v) -> frequentMap.computeIfAbsent(v, key -> new ArrayList<>()).add(k));
        StringBuilder sb = new StringBuilder();
        frequentMap.forEach((k, v) -> {
            for (Character ch : v) {
                for (int i = 0; i < k; i++) {
                    sb.append(ch);
                }
            }
        });
        return sb.toString();
    }
}
