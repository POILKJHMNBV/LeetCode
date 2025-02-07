package com.example.slidewindow;

/**
 * <p>L1888:使二进制字符串字符交替的最少反转次数</p>
 * @author zhenwu
 * @date 2025/2/7 21:44
 */
public class L1888_MinFlips {
    public static void main(String[] args) {
        String s = "01001001101";
        System.out.println(minFlips(s));
    }

    /**
     * 滑动窗口，枚举所有可能的模式（01或10），然后统计反转次数最小的那个即可。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minFlips(String s) {
        int n = s.length(), cnt = 0;
        char[] pattern = {'0', '1'};
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != pattern[i % 2]) {
                cnt++;
            }
        }

        int minCnt = Math.min(cnt, n - cnt);
        for (int i = 0; i < n; i++) {
            // 开始滑动窗口
            if (s.charAt(i) != pattern[i % 2]) {
                cnt--;
            }
            if (s.charAt(i) != pattern[(i + n) % 2]) {
                cnt++;
            }
            minCnt = Math.min(minCnt, Math.min(cnt, n - cnt));
        }
        return minCnt;
    }
}
