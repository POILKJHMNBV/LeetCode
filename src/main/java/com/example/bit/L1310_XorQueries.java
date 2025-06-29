package com.example.bit;

import java.util.Arrays;

/**
 * <p>L1310:子数组异或查询</p>
 * @author zhenwu
 * @date 2025/6/29 20:42
 */
public class L1310_XorQueries {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    /**
     * 时间复杂度: O(n + m), m 为 queries 的长度
     * 空间复杂度: O(1)
     */
    private static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] preXor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preXor[i + 1] = preXor[i] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = preXor[queries[i][0]] ^ preXor[queries[i][1] + 1];
        }
        return ans;
    }
}
