package com.example.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1297:子串的最大出现次数</p>
 * <p>
 *     给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 *     1. 子串中不同字母的数目必须小于等于 maxLetters 。
 *     2. 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 * </p>
 * @author zhenwu
 * @date 2025/2/6 21:24
 */
public class L1297_MaxFreq {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> cntMap = new HashMap<>();
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < minSize; i++) {
            indexMap.put(s.charAt(i), i);
        }
        if (indexMap.size() <= maxLetters) {
            cntMap.put(s.substring(0, minSize), 1);
        }
        int n = s.length();
        for (int i = minSize; i < n; i++) {
            char ch = s.charAt(i - minSize);
            if (indexMap.containsKey(ch) && (i - minSize) == indexMap.get(ch)) {
                indexMap.remove(ch);
            }
            indexMap.put(s.charAt(i), i);
            if (indexMap.size() <= maxLetters) {
                String str = s.substring(i - minSize + 1, i + 1);
                cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
            }
        }
        int maxFreq = 0;
        for (int freq : cntMap.values()) {
            maxFreq = Math.max(freq, maxFreq);
        }
        return maxFreq;
    }
}
