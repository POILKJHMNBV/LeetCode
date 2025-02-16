package com.example.slidewindow;

/**
 * <p>L1234:替换子串得到平衡字符串</p>
 * @author zhenwu
 * @date 2025/2/15 22:31
 */
public class L1234_BalancedString {
    public static void main(String[] args) {
        String s = "WWEQERQWQWWRWWERQWEQ";
        System.out.println(balancedString(s));
    }

    /**
     * 滑动窗口
     * 思路：正难则反，那么我们就要求 「不替换的内容」中四个字符的出现次数必须小于等于 n/4
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int balancedString(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            cnt[ch - 'A']++;
        }
        int n = s.length(), limit = n / 4, minLen = n;
        if (check(cnt, limit)) {
            return 0;
        }
        for (int l = 0, r = -1; l < n;) {
            if (check(cnt, limit)) {
                minLen = Math.min(r - l + 1, minLen);
                // 左边界右移，缩小窗口
                cnt[chars[l++] - 'A']++;
            } else if (r < n - 1){
                // 右边界右移，增大窗口
                cnt[chars[++r] - 'A']--;
            } else {
                break;
            }
        }
        return minLen;
    }

    private static boolean check(int[] cnt, int limit) {
        int a = 'Q' - 'A', b = 'W' - 'A', c = 'E' - 'A', d = 'R' - 'A';
        return cnt[a] <= limit && cnt[b] <= limit && cnt[c] <= limit && cnt[d] <= limit;
    }
}
