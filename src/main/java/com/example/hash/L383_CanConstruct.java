package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L383:赎金信</p>
 * @author zhenwu
 * @date 2024/8/17 21:44
 */
public class L383_CanConstruct {
    public static void main(String[] args) {

    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counterA = count(ransomNote);
        Map<Character, Integer> counterB = count(magazine);
        for (Character ch : counterA.keySet()) {
            if (!counterB.containsKey(ch)) {
                return false;
            }
            if (counterB.get(ch) < counterA.get(ch)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
