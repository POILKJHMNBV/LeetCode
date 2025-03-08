package com.example.doublepointer;

/**
 * <p>L809:情感丰富的文字</p>
 * @author zhenwu
 * @date 2025/3/8 10:12
 */
public class L809_ExpressiveWords {
    public static void main(String[] args) {
        String s = "dddiiiinnssssssoooo";
        String[] words = {"dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"};
        System.out.println(expressiveWords(s, words));
    }

    /**
     * 双指针
     * 时间复杂度：O(m * n), m 为 s 的长度，n 为 words 数组中字符串的平均长度
     * 空间复杂度：O(1)
     */
    private static int expressiveWords(String s, String[] words) {
        int cnt = 0;
        for (String word : words) {
            cnt += canExpressive(s, word) ? 1 : 0;
        }
        return cnt;
    }

    private static boolean canExpressive(String s, String word) {
        char[] chars = s.toCharArray(), patterns = word.toCharArray();
        int m = chars.length, n = patterns.length, i = 0, j = 0;
        while (i < m && j < n) {
            int cnt = 0;
            char ch = chars[i];
            while (i < m && ch == chars[i]) {
                i++;
                cnt++;
            }
            if (ch != patterns[j]) {
                return false;
            }
            int match = 0;
            while (j < n && ch == patterns[j]) {
                j++;
                match++;
            }
            if (cnt < match || (cnt > match && cnt < 3)) {
                return false;
            }
        }
        return i >= m && j >= n;
    }
}
