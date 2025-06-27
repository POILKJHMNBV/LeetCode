package com.example.bit;

/**
 * <p>L1720:解码异或后的数组</p>
 * @author zhenwu
 * @date 2025/6/27 21:58
 */
public class L1720_Decode {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 0; i < n - 1; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }
}
