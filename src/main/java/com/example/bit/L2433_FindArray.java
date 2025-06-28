package com.example.bit;

import java.util.Arrays;

/**
 * <p>L2433:找出前缀异或的原始数组</p>
 * @author zhenwu
 * @date 2025/6/28 21:01
 */
public class L2433_FindArray {
    public static void main(String[] args) {
        int[] pref = {5, 2, 0, 3, 1};
        System.out.println(Arrays.toString(findArray(pref)));
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] res = new int[n];
        res[0] = pref[0];
        for (int i = 1, a = pref[0]; i < n; i++) {
            res[i] = a ^ pref[i];
            a ^= res[i];
        }
        return res;
    }
}
