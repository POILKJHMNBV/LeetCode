package com.example.bit;

/**
 * <p>L2657:找到两个数组的前缀公共数组</p>
 * @author zhenwu
 * @date 2025/6/22 22:21
 */
public class L2657_FindThePrefixCommonArray {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long p = 0, q = 0;
        for (int i = 0; i < n; ++i) {
            p |= 1L << A[i];
            q |= 1L << B[i];
            ans[i] = Long.bitCount(p & q);
        }
        return ans;
    }
}
