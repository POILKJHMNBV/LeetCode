package com.example.array;

/**
 * <p>L467:环绕字符串中唯一的子字符串</p>
 * @author zhenwu
 * @date 2025/3/29 14:53
 */
public class L467_FindSubstringInWraproundString {
    public static void main(String[] args) {
        int ch = 'b';
        System.out.println(ch);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int findSubstringInWraproundString(String s) {
        char[] chars = s.toCharArray();
        // dp[i]表示以当前字符结尾的最长字符串长度
        int[] dp = new int[26];
        for (int i = 0, k = 0, n = chars.length; i < n; i++) {
            if (k > 0 && ((chars[i] - chars[i - 1] + 26) % 26) == 1) {
                k++;
            } else {
                k = 1;
            }
            int idx = chars[i] - 'a';
            dp[idx] = Math.max(dp[idx], k);
        }
        int cnt = 0;
        for (int num : dp) {
            cnt += num;
        }
        return cnt;
    }
}
