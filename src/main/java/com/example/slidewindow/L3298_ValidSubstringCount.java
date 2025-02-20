package com.example.slidewindow;

/**
 * <p>L3298:统计重新排列后包含另一个字符串的子字符串数目 II</p>
 * @author zhenwu
 * @date 2025/2/20 20:47
 * @see L76_MinWindow
 */
public class L3298_ValidSubstringCount {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static long validSubstringCount(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m < n) {
            return 0;
        }
        int[] pattern = new int[26];
        int matches = 0;
        for (int i = 0; i < n; i++) {
            int idx = word2.charAt(i) - 'a';
            if (pattern[idx] == 0) {
                matches++;
            }
            pattern[idx]++;
        }

        int[] window = new int[26];
        long ans = 0;
        char[] chars = word1.toCharArray();
        for (int l = 0, r = 0, match = 0; r < m; r++) {
            int idx = chars[r] - 'a';
            window[idx]++;
            if (window[idx] == pattern[idx]) {
                match++;
            }
            while (match == matches) {
                idx = chars[l++] - 'a';
                window[idx]--;
                if (window[idx] < pattern[idx]) {
                    match--;
                }
            }
            ans += l;
        }
        return ans;
    }
}
