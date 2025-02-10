package com.example.slidewindow;

/**
 * <p>L1208:尽可能使字符串相等</p>
 * @author zhenwu
 * @date 2025/2/10 21:11
 */
public class L1208_EqualSubstring {
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    /**
     * 尽可能使字符串相等
     * <p>滑动窗口</p>
     * <p>时间复杂度：O(n)</p>
     * <p>空间复杂度：O(1)</p>
     */
    private static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int maxLen = 0;
        for (int r = 0, l = 0, totalCost = 0; r < n; r++) {
            totalCost += cost[r];
            while (totalCost > maxCost) {
                totalCost -= cost[l++];
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
