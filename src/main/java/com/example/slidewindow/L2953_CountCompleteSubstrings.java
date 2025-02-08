package com.example.slidewindow;

/**
 * <p>L2953:统计完全子字符串</p>
 * @author zhenwu
 * @date 2025/2/8 21:14
 */
public class L2953_CountCompleteSubstrings {

    public static void main(String[] args) {
        String word = "jjjqq";
        int k = 1;
        System.out.println(countCompleteSubstrings(word, k));
    }

    /**
     * 滑动窗口 + 计数
     * 时间复杂度：O(n * 26 * 26)
     * 空间复杂度：O(1)
     */
    private static int countCompleteSubstrings(String word, int k) {
        char[] chars = word.toCharArray();
        int n = chars.length, count = 0;
        for (int i = 0; i < n; ) {
            int st = i;
            i++;
            while (i < n && Math.abs(chars[i] - chars[i - 1]) <= 2) {
                i++;
            }
            if (i - st < k) {
                continue;
            }
            count += countSubStr(chars, st, i, k);
        }
        return count;
    }

    private static int countSubStr(char[] chars, int l, int r, int k) {
        int len = r - l, ans = 0;
        // 窗口大小固定为 m * k
        for (int m = 1; m <= 26 && m * k <= len; m++) {
            int[] cnt = new int[26];
            for (int i = l; i < r; i++) {
                cnt[chars[i] - 'a']++;
                int left = i + 1 - m * k;
                if (left >= l) {
                    boolean found = true;
                    for (int num : cnt) {
                        if (num > 0 && num != k) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        ans++;
                    }
                    cnt[chars[left] - 'a']--;
                }
            }
        }
        return ans;
    }
}
