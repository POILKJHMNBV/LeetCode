package com.example.slidewindow;

/**
 * <p>L3090:每个字符最多出现两次的最长子字符串</p>
 * <p>
 *     给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的最大长度。
 * </p>
 * @author zhenwu
 * @date 2025/2/9 10:41
 */
public class L3090_MaximumLengthSubstring {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(maximumLengthSubstring(s));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maximumLengthSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length, maxLen = 2;
        int[] cnt = new int[26];
        for (int r = 0, l = 0; r < n; r++) {
            int idx = chars[r] - 'a';
            cnt[idx]++;
            while (cnt[idx] > 2) {
                // 移动左边界，直到满足每个字符最多出现两次
                cnt[chars[l++] - 'a']--;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
