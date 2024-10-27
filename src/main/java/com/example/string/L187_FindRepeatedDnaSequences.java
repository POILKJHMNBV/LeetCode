package com.example.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>L187:重复的DNA序列</p>
 * @author zhenwu
 * @date 2024/10/27 21:32
 */
public class L187_FindRepeatedDnaSequences {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                result.add(str);
            } else {
                set.add(str);
            }
        }
        return new ArrayList<>(result);
    }
}
