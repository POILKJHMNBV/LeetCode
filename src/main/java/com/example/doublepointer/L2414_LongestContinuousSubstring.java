package com.example.doublepointer;

/**
 * <p>L2414:最长的字母序连续子字符串的长度</p>
 * @author zhenwu
 * @date 2025/3/20 21:21
 */
public class L2414_LongestContinuousSubstring {
    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(longestContinuousSubstring(s));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 1;
        for (int i = 0, n = chars.length; i < n; i++) {
            char ch = chars[i];
            int cnt = 0;
            while (i < n && ch + cnt == chars[i]) {
                cnt++;
                i++;
            }
            maxLen = Math.max(maxLen, cnt);
            i--;
        }
        return maxLen;
    }
}
