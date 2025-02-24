package com.example.slidewindow;

/**
 * <p>L1156:单字符重复子串的最大长度</p>
 * @author zhenwu
 * @date 2025/2/24 22:00
 */
public class L1156_MaxRepOpt1 {
    public static void main(String[] args) {
        String text = "aaababa";
        System.out.println(maxRepOpt1(text));
    }

    /**
     * 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int maxRepOpt1(String text) {
        char[] chars = text.toCharArray();
        int[] totalCnt = new int[26], cnt = new int[26];
        for (char ch : chars) {
            totalCnt[ch - 'a']++;
        }
        // maxCount为当前窗口重复最多元素数量
        int n = chars.length, maxLen = 0, maxCount = 0;
        for (int l = 0, r = 0; r < n; r++) {
            int idx = chars[r] - 'a';
            cnt[idx]++;
            if (totalCnt[idx] - 1 > maxCount) {
                maxCount = Math.max(maxCount, cnt[idx]);
            }
            while (r - l + 1 > maxCount + 1) {
                cnt[chars[l++] - 'a']--;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
