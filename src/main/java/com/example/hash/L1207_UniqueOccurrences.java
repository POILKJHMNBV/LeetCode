package com.example.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <p>L1207:独一无二的出现次数</p>
 * @author zhenwu
 * @date 2024/9/2 20:48
 */
public class L1207_UniqueOccurrences {
    public static void main(String[] args) {

    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return new HashSet<>(map.values()).size() == map.size();
    }
}
