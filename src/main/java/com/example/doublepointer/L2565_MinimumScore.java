package com.example.doublepointer;

/**
 * <p>L2565:最少得分子序列</p>
 * @author zhenwu
 * @date 2025/3/14 20:01
 */
public class L2565_MinimumScore {
    public static void main(String[] args) {
        String s = "abacaba", t = "bzaa";
        System.out.println(minimumScore(s, t));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int minimumScore(String s, String t) {
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        int m = sChars.length, n = tChars.length;

        // 定义 suf[i] 为 s[i:] 对应的 t 的最长后缀的开始下标
        int[] suf = new int[m + 1];
        suf[m] = n;
        for (int i = m - 1, j = n - 1; i >= 0; i--) {
            if (sChars[i] == tChars[j]) {
                j--;
            }
            if (j < 0) {
                return 0;
            }
            suf[i] = j + 1;
        }

        int ans = suf[0];
        for (int i = 0, j = 0; i < m; i++) {
            if (sChars[i] == tChars[j]) {
                j++;
                // 注意上面判断了 t 是 s 子序列的情况，这里 j 不会越界
                ans = Math.min(ans, suf[i + 1] - j);    // 移除 [j, suf[i + 1]) 的字符
            }
        }
        return ans;
    }
}
