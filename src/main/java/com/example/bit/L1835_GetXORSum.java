package com.example.bit;

/**
 * <p>L1835:所有数对按位与结果的异或和</p>
 * @author zhenwu
 * @date 2025/7/22 22:26
 */
public class L1835_GetXORSum {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n + m)
     * 空间复杂度: O(1)
     */
    private static int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0, xor2 = 0;
        for (int num : arr1) {
            xor1 ^= num;
        }
        for (int num : arr2) {
            xor2 ^= num;
        }
        return xor1 & xor2;
    }
}
