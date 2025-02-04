package com.example.slidewindow;

import java.util.Arrays;

/**
 * <p>L1652:拆炸弹</p>
 * @author zhenwu
 * @date 2025/2/4 10:49
 */
public class L1652_Decrypt {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            Arrays.fill(res, k);
            return res;
        }
        // 第一个窗口的右开端点
        int r = k > 0 ? k + 1 : n;
        k = Math.abs(k);
        int sum = 0;
        for (int i = r - k; i < r; i++) {
            sum += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum += code[r % n] - code[(r - k) % n];
            r++;
        }
        return res;
    }
}
