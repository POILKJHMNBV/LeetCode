package com.example.bit;

/**
 * <p>L389:找不同</p>
 * @author zhenwu
 * @date 2025/1/8 21:15
 */
public class L389_FindTheDifference {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        return (char) res;
    }
}
