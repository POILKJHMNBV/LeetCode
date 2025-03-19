package com.example.doublepointer;

/**
 * <p>L1446:连续字符</p>
 * @author zhenwu
 * @date 2025/3/19 22:35
 */
public class L1446_MaxPower {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int maxPower(String s) {
        int len = s.length(), maxLen = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            char ch = chars[i];
            while (i < len && ch == chars[i]) {
                i++;
                cnt++;
            }
            maxLen = Math.max(maxLen, cnt);
            i--;
        }
        return maxLen;
    }
}
