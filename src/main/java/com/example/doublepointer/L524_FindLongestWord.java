package com.example.doublepointer;

import java.util.List;

/**
 * <p>L524:通过删除字母匹配到字典里最长单词</p>
 * @author zhenwu
 * @date 2025/3/11 21:20
 */
public class L524_FindLongestWord {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(m * n), m 为 s 的长度，n 为 dictionary 中字符串的平均长度
     * 空间复杂度：O(1)
     */
    private static String findLongestWord(String s, List<String> dictionary) {
        String longest = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (longest.length() < word.length() ||
                        (longest.length() == word.length() && longest.compareToIgnoreCase(word) > 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        for (int i = 0, j = 0, n = t.length(); i < n; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                if (++j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
