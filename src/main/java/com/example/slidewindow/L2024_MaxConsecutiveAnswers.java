package com.example.slidewindow;

/**
 * <p>L2024:考试的最大困扰度</p>
 * @author zhenwu
 * @date 2025/2/16 10:38
 */
public class L2024_MaxConsecutiveAnswers {

    public static void main(String[] args) {

    }

    /**
     * 求 answerKey 的一个最长子串，至多包含 k 个 T 或者至多包含 k 个 F。
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int[] cnt = new int[26];
        int maxLen = 0;
        for (int l = 0, r = 0, n = chars.length; r < n; r++) {
            cnt[chars[r] - 'A']++;
            while (Math.min(cnt['T' - 'A'], cnt['F' - 'A']) > k) {
                cnt[chars[l++] - 'A']--;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
