package com.example.slidewindow;

/**
 * <p>L2516:每种字符至少取 K 个</p>
 * @author zhenwu
 * @date 2025/2/12 20:34
 */
public class L2516_TakeCharacters {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int takeCharacters(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[chars[i] - 'a']++;
        }
        int x = cnt[0] - k, y = cnt[1] - k, z = cnt[2] - k;
        if (x < 0 || y < 0 || z < 0) {
            return -1;
        }
        int maxLen = 0;
        int[] tmpCnt = new int[3];
        for (int l = 0, r = 0; r < n; r++) {
            tmpCnt[chars[r] - 'a']++;
            while (tmpCnt[0] > x || tmpCnt[1] > y || tmpCnt[2] > z) {
                tmpCnt[chars[l++] - 'a']--;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return n - maxLen;
    }
}
