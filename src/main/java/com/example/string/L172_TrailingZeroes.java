package com.example.string;

/**
 * <p>L172:阶乘后的零</p>
 * @author zhenwu
 * @date 2024/10/25 21:47
 */
public class L172_TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(32));
    }

    /**
     * 计算n!中尾随零的数量
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    private static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
