package com.example.string;

/**
 * <p>L190:颠倒二进制位</p>
 * @author zhenwu
 * @date 2024/10/11 21:40
 */
public class L190_ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    /**
     * 时间：O(1)   空间：O(1)
     */
    private static int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
