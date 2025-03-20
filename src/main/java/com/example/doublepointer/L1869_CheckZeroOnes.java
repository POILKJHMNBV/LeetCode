package com.example.doublepointer;

/**
 * <p>L1869:哪种连续子字符串更长</p>
 * @author zhenwu
 * @date 2025/3/20 21:13
 */
public class L1869_CheckZeroOnes {
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(checkZeroOnes(s));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean checkZeroOnes(String s) {
        char[] chars = s.toCharArray();
        int maxLen0 = 0, maxLen1 = 0;
        for (int i = 0, n = chars.length; i < n; i++) {
            char ch = chars[i];
            int cnt = 0;
            while (i < n && chars[i] == ch) {
                i++;
                cnt++;
            }
            if (ch == '0') {
                maxLen0 = Math.max(maxLen0, cnt);
            } else {
                maxLen1= Math.max(maxLen1, cnt);
            }
            i--;
        }
        return maxLen1 > maxLen0;
    }
}
