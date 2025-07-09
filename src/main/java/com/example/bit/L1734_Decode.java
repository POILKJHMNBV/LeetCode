package com.example.bit;

/**
 * <p>L1734:解码异或后的排列</p>
 * @author zhenwu
 * @date 2025/7/9 21:42
 */
public class L1734_Decode {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
