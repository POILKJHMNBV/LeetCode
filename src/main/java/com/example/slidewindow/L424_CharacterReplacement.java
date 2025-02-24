package com.example.slidewindow;

/**
 * <p>L424:替换后的最长重复字符</p>
 * @author zhenwu
 * @date 2025/2/24 22:15
 */
public class L424_CharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int[] cnt = new int[26];
        for (int l = 0, r = 0, maxFreq = 0, n = s.length(); r < n; r++) {
            int idx = chars[r] - 'A';
            cnt[idx]++;
            maxFreq = Math.max(maxFreq, cnt[idx]);
            if (r - l + 1 > maxFreq + k) {
                cnt[chars[l] - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
