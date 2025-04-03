package com.example.binaryserach;

/**
 * <p>L1170:比较字符串最小字母出现频次</p>
 * @author zhenwu
 * @date 2025/4/3 21:50
 */
public class L1170_NumSmallerByFrequency {
    public static void main(String[] args) {

    }

    /**
     * 后缀和
     * 时间：O((n+m)p)，其中 n 是 queries 的长度，m 是 words 的长度，p 是 queries 和 words 中的最长字符串的长度。
     * 空间：O(1)
     */
    private static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];
        for (String word : words) {
            count[f(word)]++;
        }
        for (int i = 9; i >= 0; i--) {
            count[i] += count[i + 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0, n = queries.length; i < n; i++) {
            ans[i] = count[f(queries[i]) + 1];
        }
        return ans;
    }

    private static int f(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        char ch = 'z';
        for (char c : chars) {
            if (c < ch) {
                ch = c;
                cnt = 1;
            } else if (c == ch) {
                cnt++;
            }
        }
        return cnt;
    }
}
