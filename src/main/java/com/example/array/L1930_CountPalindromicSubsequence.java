package com.example.array;


/**
 * <p>L1930:长度为 3 的不同回文子序列</p>
 * @author zhenwu
 * @date 2025/5/10 8:59
 */
public class L1930_CountPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "adc";
        System.out.println(countPalindromicSubsequence(s));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int countPalindromicSubsequence(String s) {
        // 记录当前字符左右两边出现的字符
        char[] charArray = s.toCharArray();
        int[] suf = new int[26], pre = new int[26], hash = new int[26];
        int n = charArray.length;
        for (int i = 1; i < n; i++) {
            suf[charArray[i] - 'a']++;
        }
        for (int i = 1; i < n - 1; i++) {
            pre[charArray[i - 1] - 'a']++;
            suf[charArray[i] - 'a']--;
            for (int j = 0; j < 26; j++) {
                if (pre[j] > 0 && suf[j] > 0) {
                    // 位运算去重
                    hash[charArray[i] - 'a'] |= 1 << j;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += Integer.bitCount(hash[i]);
        }
        return cnt;
    }
}
