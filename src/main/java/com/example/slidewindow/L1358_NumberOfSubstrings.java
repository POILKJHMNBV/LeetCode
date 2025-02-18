package com.example.slidewindow;

/**
 * <p>L1358:包含所有三种字符的子字符串数目</p>
 * @author zhenwu
 * @date 2025/2/18 20:01
 */
public class L1358_NumberOfSubstrings {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstringsPro(s));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int numberOfSubstringsPro(String s) {
        char[] chars = s.toCharArray();
        int n = s.length(), ans = 0;
        int[] cnt = new int[3];
        for (int l = 0, r = 0; r < n; r++) {
            cnt[chars[r] - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[chars[l++] - 'a']--;
            }
            ans += l;
        }
        return ans;
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(1)
     */
    private static int numberOfSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0, matches = 3;
        for (int l = 0; l < n - 2; l++) {
            int[] cnt = new int[3];
            for (int r = l, match = 0; r < n; r++) {
                if (cnt[chars[r] - 'a'] == 0) {
                    match++;
                }
                cnt[chars[r] - 'a']++;
                if (match == matches) {
                    ans += n - r;
                    break;
                }
            }
        }
        return ans;
    }
}
