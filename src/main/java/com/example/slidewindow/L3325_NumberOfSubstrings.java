package com.example.slidewindow;

/**
 * <p>L3325:字符至少出现 K 次的子字符串 I</p>
 * @author zhenwu
 * @date 2025/2/18 20:20
 */
public class L3325_NumberOfSubstrings {
    public static void main(String[] args) {
        String s = "biikmbqb";
        int k = 2;
        System.out.println(numberOfSubstrings(s, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int numberOfSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        int ans = 0;
        for (int l = 0, r = 0, n = s.length(); r < n; r++) {
            int idx = chars[r] - 'a';
            cnt[idx]++;
            while (cnt[idx] >= k) {
                cnt[chars[l++] - 'a']--;
            }
            ans += l;
        }
        return ans;
    }
}
