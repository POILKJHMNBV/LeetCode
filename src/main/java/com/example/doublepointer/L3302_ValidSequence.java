package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L3302:字典序最小的合法序列</p>
 * @author zhenwu
 * @date 2025/3/15 8:50
 */
public class L3302_ValidSequence {
    public static void main(String[] args) {
        String word1 = "abacaba";
        String word2 = "cab";
        System.out.println(Arrays.toString(validSequence(word1, word2)));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] validSequence(String word1, String word2) {
        char[] s = word1.toCharArray(), t = word2.toCharArray();
        int m = s.length, n = t.length;

        // 定义 suf[i] 为 s[i:] 对应的 t 的最长后缀的开始下标
        int[] suf = new int[m + 1];
        suf[m] = m;
        for (int i = m - 1, j = n - 1; i >= 0; --i) {
            if (j >= 0 && s[i] == t[j]) {
                j--;
            }
            suf[i] = j + 1;
        }

        boolean needChange = false;
        int[] ans = new int[n];
        for (int i = 0, j = 0; i < m; i++) {
            // 当前字符匹配，或者不需要替换且后续子序列可以匹配 t[j+1:]
            if (s[i] == t[j] || !needChange && suf[i + 1] <= j + 1) {
                if (s[i] != t[j]) {
                    // 替换为 t[j]
                    needChange = true;
                }
                ans[j++] = i;
                if (j == n) {
                    return ans;
                }
            }
        }
        return new int[0];
    }
}
