package com.example.array;

import java.util.Arrays;

/**
 * <p>L338:比特位计数</p>
 * @author zhenwu
 * @date 2024/9/22 10:10
 */
public class L338_CountBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
        System.out.println(Arrays.toString(countBitsPro(n)));
    }

    private static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    private static int[] countBitsPro(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
