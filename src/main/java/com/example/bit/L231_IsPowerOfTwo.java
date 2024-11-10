package com.example.bit;

/**
 * <p>L231:2 的幂</p>
 * @author zhenwu
 * @date 2024/11/10 21:34
 */
public class L231_IsPowerOfTwo {
    public static void main(String[] args) {

    }

    /**
     * 判断一个数是否是 2 的幂
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
