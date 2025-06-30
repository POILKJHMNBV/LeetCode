package com.example.bit;

/**
 * <p>L2683:相邻值的按位异或</p>
 * @author zhenwu
 * @date 2025/6/30 22:24
 */
public class L2683_DoesValidArrayExist {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int x : derived) {
            xor ^= x;
        }
        return xor == 0;
    }
}
