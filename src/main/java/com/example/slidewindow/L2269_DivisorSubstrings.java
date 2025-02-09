package com.example.slidewindow;

/**
 * <p>L2269:找到一个数字的 K 美丽值</p>
 * @author zhenwu
 * @date 2025/2/9 9:11
 */
public class L2269_DivisorSubstrings {
    public static void main(String[] args) {

    }

    /**
     * 计算数字 num 的 k 美丽值
     * 时间复杂度：O(n * k)
     * 空间复杂度：O(n)
     */
    private static int divisorSubstrings(int num, int k) {
        char[] chars = Integer.toString(num).toCharArray();
        int n = chars.length, cnt = 0;
        for (int i = 0; i <= n - k; i++) {
            int cur = Integer.parseInt(new String(chars, i, k));
            if (cur != 0 && num % cur == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
