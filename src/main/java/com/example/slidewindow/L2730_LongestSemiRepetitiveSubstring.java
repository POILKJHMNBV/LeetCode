package com.example.slidewindow;

/**
 * <p>L2730:找到最长的半重复子字符串</p>
 * @author zhenwu
 * @date 2025/2/10 21:20
 */
public class L2730_LongestSemiRepetitiveSubstring {

    public static void main(String[] args) {

    }

    /**
     * 最长半重复子字符串的长度
     * <p>滑动窗口</p>
     * <p>时间复杂度：O(n)</p>
     * <p>空间复杂度：O(1)</p>
     */
    private static int longestSemiRepetitiveSubstring(String s) {
        int maxLen = 1;
        for (int r = 0, l = 0, n = s.length(), semiRep = 0; r < n - 1; r++) {
            if (s.charAt(r) == s.charAt(r + 1)) {
                semiRep++;
            }
            while (semiRep > 1) {
                if (s.charAt(l) == s.charAt(l + 1)) {
                    semiRep--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 2);
        }
        return maxLen;
    }
}
