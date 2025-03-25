package com.example.array;

/**
 * <p>L1759:统计同质子字符串的数目</p>
 * @author zhenwu
 * @date 2025/3/25 21:30
 */
public class L1759_CountHomogenous {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        long ans = 0;
        for (int i = 0, n = chars.length; i < n; i++) {
            char ch = chars[i];
            int j = i;
            while (j < n && chars[j] == ch) {
                j++;
            }
            int k = j - i;
            ans += ((long) k * (k + 1)) / 2;
            i = j - 1;
        }
        return (int) (ans % 1000000007);
    }
}
