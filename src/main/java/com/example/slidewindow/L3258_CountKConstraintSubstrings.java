package com.example.slidewindow;

/**
 * <p>L3258:统计满足 K 约束的子字符串数量 I</p>
 * @author zhenwu
 * @date 2025/2/20 20:59
 */
public class L3258_CountKConstraintSubstrings {
    public static void main(String[] args) {
        String s = "10101";
        int k = 1;
        System.out.println(countKConstraintSubstrings(s, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int l = 0, r = 0, cnt = 0, n = chars.length; r < n; r++) {
            cnt += (chars[r] - '0');
            while (cnt > k && (r - l + 1 - cnt) > k) {
                cnt -= (chars[l++] - '0');
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}
